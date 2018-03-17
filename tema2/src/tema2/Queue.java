package tema2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements Runnable {

	/**
	 * cat de buna este o coada in a-si gestiona clientii
	 */
	private AtomicInteger queueEfficency = new AtomicInteger(0);
	/**
	 * timpul mediu de asteptare al clientului la coada
	 */
	private float queueAverageWaitingTime = 0;

	/**
	 * timpul in care o coada se va goli
	 */
	private long emptyQueueTime = 0;
	/**
	 * folosit in calculul timpului mediu
	 */
	private int dividerOfClients = 1;
	/**
	 * colectia Java folosita pentru a pastra clientii in coada
	 * 
	 * Un BlockingQueue este o coada care suporta, aditional, operatii precum,
	 * asteapta ca o coada sa aibe un element apoi extragel,ori asteapta ca sa
	 * fie suficient spatiu pentru a insera un nou client in coada.
	 */
	private BlockingQueue<Client> queue;
	/**
	 * numarul unic al cozii
	 */
	private int id;

	/**
	 * contructorul cozii
	 */
	public Queue(int id) {
		queue = new ArrayBlockingQueue<Client>(10);
		this.id = id;
	}

	/**
	 * insereaza un client in coada si seteaza queueStartTime
	 */
	public void produce(Client client) throws InterruptedException {
		queue.put(client);
		client.setQueueStartTime(System.nanoTime() / Controller.divider - Controller.startTime);
	}

	/**
	 * scoate un client din coada, ii seteaza finalTime, seteaza si
	 * queueEfficency si queueAverageWaitingTime,precum si scrie intr-un fisier
	 * extern detalii despre fiecare client scos
	 */
	public void consume() throws InterruptedException {
		emptyQueueTime = queue.peek().getProcessedTime();
		Thread.sleep(queue.peek().getProcessedTime());
		queue.peek().setFinalTime(System.nanoTime() / Controller.divider - Controller.startTime);
		queueEfficency.lazySet((int) (queue.peek().getFinalTime() - queue.peek().getArrivalTime()));
		queueAverageWaitingTime = queueEfficency.get() / (10 * dividerOfClients++);
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("out.txt", true); // true tells
																	// to append
																	// data.
			out = new BufferedWriter(fstream);
			out.write(queue.peek().toString2());
			out.newLine();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		queue.take();
	}

	public int getId() {
		return id;
	}

	public int getSize() {
		return 10 - queue.remainingCapacity();
	}

	public long getQueueEfficency() {
		return queueEfficency.get();
	}

	public float getAverageWAitingTime() {
		return queueAverageWaitingTime;
	}

	/**
	 * obinte timpul de procesare de la fiecare client al cozii
	 */
	public long getProccesTime() {
		long processTime = 0;
		for (Client client : queue) {
			processTime += client.getProcessedTime();
		}
		return processTime;
	}

	public BlockingQueue<Client> getQueue() {
		return queue;
	}

	/**
	 * folosita pentru a afisa in interfata coaza cu clientii din ea
	 */
	public String toString() {
		String s = "(" + emptyQueueTime + "ms)_Q[" + this.id + "](" + queueEfficency + "score)= ";
		for (Client a : queue) {
			s += a.toString();
		}
		s += "\n";
		return s;
	}

	/**
	 * coada fiind un thread, va rula metoda run in paralel(incearca sa scoata
	 * clienti din coada),pentru fiecare instanta a clasei
	 */
	public void run() {
		while (true) {
			if (queue.size() > 0) {
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				queueEfficency.set(0);
				emptyQueueTime = 0;
			}
		}
	}
}
