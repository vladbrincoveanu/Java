package tema2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Runnable {

	/**
	 * numarul cozilor
	 */
	private int nbOfQueues = 0;
	/**
	 * timpul simularii
	 */
	private int simTime = 0;
	/**
	 * instanta view controlata de aceasta clasa
	 */
	private View view;
	/**
	 * instanta generator controlata de aceasta clasa
	 */
	private Generator generator;
	private ArrayList<Queue> queues = new ArrayList<Queue>();
	/**
	 * timpu dupa care se alege unde se va insera clientul
	 *
	 */
	private long bestQueueTime = 9999999999l;
	/**
	 * lungimea dupa care se alege unde se va insera clientul
	 */
	private long bestLength = 9999999999l;
	/**
	 * folosit la aflarea timpului curent
	 */
	public static int divider = 1000000;
	/**
	 * timpul de inceput al simularii
	 */
	public static long startTime = System.nanoTime() / divider;

	private boolean restart = false;
	/**
	 * un obiect care executa si inchide obiectele ce implementeaza
	 * runnable(threads, ruleaza paralel)
	 */
	private ExecutorService services = Executors.newCachedThreadPool();

	/**
	 * contructorul Controlerului instanteaza listeneri pentru interfata dar si
	 * leaga generatorul si interfata de acesta
	 */
	public Controller(View v, Generator g) {
		this.view = v;
		this.generator = g;
		v.startListener(new startListener());
		v.restartListener(new restartListener());
		v.setListener(new SetListener());
	}

	/**
	 * implementeaza actiunea pe butonul start
	 */
	class startListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			start();
		}
	}

	/**
	 * metoda ce executa generatorul,cozile precum si controlerul folosind clasa
	 * Executor
	 */
	public void start() {
		services.execute(generator);
		services.execute(this);
		for (Queue c : queues) {
			services.execute(c);
		}
	}

	/**
	 * metoda set ce va initializa toate variabilele date de interfata, precum:
	 * timpi de simulare , timpi de clienti, numarul cozilor etc
	 */
	class SetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				populateFields();
				populateQueues();
				view.setQueues(nbOfQueues);
				view.setSimTime("0");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * reseteaza toate campurile, inchide toate cozile reseteaza viewul
	 */
	class restartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			restart = true;

		}
	}

	/**
	 * metoda de baza a clasei, scoate cate un client din generator ii seteaza
	 * anumiti timpi apoi decide la ce coada sa-l trimita
	 */
	public void getClient() {
		Client c = null;
		try {
			c = generator.getStocareClienti().take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setArrivalTime(System.nanoTime() / divider - startTime);
		for (Queue coda : queues) {
			if (coda.getId() == checkEfficency()) {
				try {
					coda.produce(c);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	/**
	 * metoda care verifica eficienta fiecarei cozi in rulare si decide care
	 * coada sa fie aleasa, in functie de eficienta, pentru a adauga un client
	 * in ea
	 */
	public int checkEfficency() {
		int queueId = 0;
		HashMap<Integer, Integer> aux = new HashMap<Integer, Integer>();
		for (Queue coada : queues) {
			aux.put(coada.getId(), (int) (coada.getQueueEfficency() + coada.getProccesTime() / 2));
		}
		bestQueueTime = 99999999l;
		for (Entry<Integer, Integer> entry : aux.entrySet()) {
			if (entry.getValue() < bestQueueTime) {
				bestQueueTime = entry.getValue();
				queueId = entry.getKey();
			}
		}
		return queueId;
	}

	/**
	 * metoda care verifica eficienta fiecarei cozi in rulare si decide care
	 * coada sa fie aleasa, in functie de clienti deja aflati in coada, pentru a
	 * adauga un client in ea
	 */
	public int checkLength() {
		int queueId = 0;
		HashMap<Integer, Integer> aux = new HashMap<Integer, Integer>();
		for (Queue coada : queues) {
			aux.put(coada.getId(), coada.getSize());
		}
		bestLength = 99999999l;
		for (Entry<Integer, Integer> entry : aux.entrySet()) {
			if (entry.getValue() < bestLength) {
				bestLength = entry.getValue();
				queueId = entry.getKey();
			}
		}
		return queueId;
	}

	/**
	 * scoate toate informatiile din interfata introduse de utilizator, apoi
	 * instanteaza clientul si controllerul cu acestea
	 */
	public void populateFields() throws InterruptedException {
		String s = "";
		s = view.getMaxIntervalTextArea();
		// Generator.maxIntervalTime=Integer.parseInt(s);
		generator.setMaxIntervalTime(Integer.parseInt(s));
		// maxIntervalTime = Integer.parseInt(s);

		s = view.getMinIntevalTextArea();
		generator.setMaxIntervalTime(Integer.parseInt(s));
		// Generator.minIntervalTime = Integer.parseInt(s);
		// minIntervalTime = Integer.parseInt(s);

		s = view.getMaxServiceTimeTextArea();
		generator.setMaxProcessedTime(Integer.parseInt(s));
		// Generator.maxProcessedTime = Integer.parseInt(s);

		s = view.getMinServiceTimeTextArea();
		generator.setMinProcessedTime(Integer.parseInt(s));
		// Generator.minProcessedTime = Integer.parseInt(s);

		nbOfQueues = Integer.parseInt(view.getNbOfQueuesTextArea());
		view.setNbOfQueues(nbOfQueues);

		simTime = Integer.parseInt(view.getSimIntervalTextArea());
		Thread.sleep(100);
	}

	/**
	 * scoate toate informatiile din interfata introduse de utilizator, apoi
	 * instanteaza coziile cu acestea
	 */
	public void populateQueues() {
		if (nbOfQueues != 0) {
			for (int i = 1; i <= nbOfQueues; i++) {
				queues.add(new Queue(i));
			}
		} else {
			view.showError("No queues were instantiated!");
		}
	}

	/**
	 * scoate clienti din generator, decide in care coada sa ii introduca,
	 * actualizeaza interfata cu informatii privind cozile,verifica cand timpul
	 * simularii a ajuns la final si inchide Runnables.
	 */
	public void run() {
		String s = "";
		while (true) {
			getClient();
			for (Queue c : queues) {
				view.getJpb().get(c.getId() - 1).setValue(c.getSize());
				s += c.toString() + "\n";
			}
			view.setLog(s);
			s = "";
			view.setSimTime(Long.toString(System.nanoTime() / divider - startTime));
			if (Math.abs(System.nanoTime() / divider - startTime) > simTime) {
				services.shutdown();
				for (Queue c : queues) {
					view.getJpb().get(c.getId() - 1).setValue(0);
					s += "Queue[" + c.getId() + "] has averageWaitingTime of =" + c.getAverageWAitingTime() + " s\n";
				}
				view.setLog(s);
				break;
			}
			if (restart == true) {
				services.shutdown();
				for (Queue c : queues) {
					view.getJpb().get(c.getId() - 1).setValue(0);
				}
				s = "Simularea s-a incheiat fortat!";
				view.setLog(s);
				break;
			}
		}
	}
}
