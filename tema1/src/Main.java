
public class Main {

	/**
	 * se vor initializa interfata operatiile si controllerul
	 */
	public static void main(String[] args) {

		Interfata view = new Interfata();
		Operatii op = new Operatii();
		@SuppressWarnings("unused")
		Controller c = new Controller(view, op);
	}
}
