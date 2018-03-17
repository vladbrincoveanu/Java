package tema2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Generator implements Runnable{

	/**
	 *genereaza variatii de timpi pentru o simulare cat
	 *mai reala
	 */
	private Random value = new Random();
	/**
	 *numarul unic al fiecarui client generat in metoda generate
	 */
	private int contor = 0;
	/**
	 *timpul minim de procesare a clientului
	 */
	private int minProcessedTime=0;
	/**
	 *timpul maxim de procesare a clientului
	 */
	private int maxProcessedTime=0;
	/**
	 *timpul minim dintre doi clienti generati
	 */
	private int minIntervalTime=0;
	/**
	 *timpul maxim dintre doi clienti generati
	 */
	private int maxIntervalTime=0;
	/**
	 *clientii generati sunt stocati aici,asteptand sa fie
	 *dati controlerului
	 */
	private BlockingQueue<Client> stocareClienti = new LinkedBlockingQueue<Client>();

	/**
	 *contrucoturl clasei generator
	 */
	public Generator() {
	
	}

	/**
	 *genereaza clienti,cu timpii dati si in intervalele de timp
	 *date,apoi ii stocheaza in stocareClienti
	 */
	public void generates() {
		while (true) {
			try {
				Thread.sleep(value.nextInt(maxIntervalTime) + minIntervalTime);
				stocareClienti.put( new Client(Integer.toString(contor++), value.nextInt(maxProcessedTime)+minProcessedTime));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getMinProcessedTime() {
		return minProcessedTime;
	}

	public void setMinProcessedTime(int minProcessedTime) {
		this.minProcessedTime = minProcessedTime;
	}

	public int getMaxProcessedTime() {
		return maxProcessedTime;
	}

	public void setMaxProcessedTime(int maxProcessedTime) {
		this.maxProcessedTime = maxProcessedTime;
	}

	public int getMinIntervalTime() {
		return minIntervalTime;
	}

	public void setMinIntervalTime(int minIntervalTime) {
		this.minIntervalTime = minIntervalTime;
	}

	public int getMaxIntervalTime() {
		return maxIntervalTime;
	}

	public void setMaxIntervalTime(int maxIntervalTime) {
		this.maxIntervalTime = maxIntervalTime;
	}

	public BlockingQueue<Client> getStocareClienti() {
		return stocareClienti;
	}
	
	
	public void printfClienti(){
		for(Client q: stocareClienti){
			System.out.println(q);
		}
	}
	
	/**
	 *genereaza clienti, generatorul va produce clienti in paralel
	 *fata de celelate task-uri 
	 */
	public void run() {
		generates();
	}
}
