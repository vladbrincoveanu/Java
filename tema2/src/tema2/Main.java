package tema2;

public class Main {
	/**
	 * instanteaza interfata controlerul si generatorul
	 */
	public static void main(String[] args){
		View v = new View();
		Generator g = new Generator();
		@SuppressWarnings("unused")
		Controller contr = new Controller(v,g);	
	}
}