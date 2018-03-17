package tema2;

public class Client {

	/**
	 *numarul unic al clientului
	 */
	private String id;
	/**
	 * spune cand clientul intra in magazin(controller)
	 * 
	 */
	private long arrivalTime;
	/**
	 * spune cand clientul iese de la coada
	 */
	private long finalTime;
	/**
	 * spune cat ii va lua cozii sa proceseze clientul
	 */
	private long processedTime;
	/**
	 * spune cand clientul intra in coada
	 */
	private long queueStartTime;

	/**
	 * contructorul clasei Client
	 */
	public Client(String id, int processedTime) {
		this.id = id;
		this.arrivalTime = 0;
		this.finalTime = 0;
		this.queueStartTime = 0;
		this.processedTime = processedTime;
	}

	public void setArrivalTime(long time) {
		this.arrivalTime = time;
	}

	public void setFinalTime(long time) {
		this.finalTime = time;
	}

	public void setProcessedTime(long time) {
		this.processedTime = time;
	}

	public void setQueueStartTime(long time) {
		this.queueStartTime = time;
	}

	public long getQueueStartTime() {
		return queueStartTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public long getFinalTime() {
		return finalTime;
	}

	public long getProcessedTime() {
		return processedTime;
	}

	/**
	 * toata informatia despre timpi, pe care o poarta clientul.
	 * (poate fi scrisa intr-un fisier extern)
	 */
	public String toString2() {
		return "Id= " + id + " aTime= " + arrivalTime + "ms" + " fTime= " + finalTime + "ms" + " Process= "
				+ processedTime;
	}
	
	/**
	 *un rezumat al informatiei purtate de client.(poate fi scrisa
	 *in interfata)
	 */
	public String toString() {
		return id+", ";
	}
}