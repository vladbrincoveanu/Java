import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	/**
	 *variabila instanta a interfetei 
	 */
	private Interfata view;
	
	/**
	 *variabila instanta a modelului(clasa Operatii) 
	 */
	private Operatii operatii;
	
	/**
	 *variabila de numarare a aparitie pe ecran a polinomului 
	 */
	private int nrPolinoame = 0;
	
	/**
	 *variabila de conditionare asupra unor apasari gresite 
	 *a unor butoane 
	 */
	private int nrPolinom = 0;
	
	/**
	 *polinomul rezultat in urma efectuarii operatiilor din clasa
	 *model 
	 */
	private Polinom rezultat = new Polinom();
	
	/**
	 *variabila de conditionare asupra unor apasari gresite 
	 *a unor butoane  
	 */
	private boolean AdaugaPressed = false;

	/**
	 *constructorul care primeste si modelul si view-ul ca si 
	 *parametrii, in care se mai instaneaza si Ascultatorii
	 *ce vor fi implementati in aceasta clasa
	 */
	Controller(Interfata v, Operatii op) {
		operatii = op;
		view = v;
		view.addAdaugaListener(new AdaugaListener());
		view.addStartListener(new StartListener());
		view.addClearListener(new ClearListener());
	}
	
	/**
	 *clasa ce implementeaza ascultatorul pe butonul "Adauga"
	 *Se primeste string-ul dat de utilizator, se paseaza catre 
	 *clasa Operatii unde se face parsarea si se returneaza 
	 *polinoamele care vor fi date View-ului sa le afiseze pe
	 *ecran+cateva conditionari de eroare
	 */
	class AdaugaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdaugaPressed = true;
			String userInput = "";
			try {
				userInput = view.getUserInput();
				operatii.regexChecker(userInput);
			} catch (Exception e2) {
				view.showError("Error! ");
			}

			if (userInput.equals("")) {
				view.showError("Nicio inregistrare, clear si refa!");
			} else {
				if (nrPolinoame == 0) {
					view.setTextPolinom("Polinomul a = ", operatii.getPolinomAFromParser());
					nrPolinom = 1;
				} else if (nrPolinoame == 1) {
					view.setTextPolinom("Polinomul b = ", operatii.getPolinomBFromParser());
					nrPolinom = 2;
				} else {
					resetAllIntermediates();
					view.showError("Nu s-a putut initializa polinomul: " + operatii.getPolA());
				}
				nrPolinoame++;
				if (nrPolinoame == 2) {
					nrPolinoame = 0;
				}
			}
		}
	}

	/**
	 *clasa ce implementeaza ascultatorul pe butonul "Clear"
	 * Se apeleaza metoda reset de view si metoda reset din 
	 * Controller
	 */
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.reset();
			resetAllIntermediates();
		}
	}

	/**
	 *se vor reinitializa toate variabilele instanta
	 */
	private void resetAllIntermediates() {
		nrPolinoame = 0;
		operatii.reset();
		rezultat = new Polinom();
		AdaugaPressed = false;
		nrPolinom = 0;
	}

	/**
	 *clasa ce implementeaza ascultatorul pe butonul "Start"
	 * Se verifica ce operatie s-a selectat, comunica cu modelul
	 * si cu View-ul pentru a rezolva operatia si a afisa rezultatul
	 * pe ecran+multe pop-up-uri de erori daca utilizatorul nu a 
	 * respectat scenariile scrise in documentatie 
	 */
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String selected = (String) view.getComboBox().getSelectedItem();
			String[] names = view.getStringFromComboBox();
			// "Adunare", "Scadere", "Impartire", "Inmultire", "Derivare",
			// "Integrare"

			if (AdaugaPressed) {
				try {
					if (nrPolinom == 2) {
						if (selected == names[0]) {
							rezultat = operatii.adunare(operatii.getPolA(), operatii.getPolB());
							view.setText("S-a selectat Adunare!");
						} else if (selected == names[1]) {
							rezultat = operatii.scadere(operatii.getPolA(), operatii.getPolB());
							view.setText("S-a selectat Scadere!");
						} else if (selected == names[2]) {
							rezultat = operatii.impartire(operatii.getPolA(), operatii.getPolB());
							view.setText("S-a selectat Impartire!");
							view.setText("Restul = " + operatii.getRest());
						} else if (selected == names[3]) {
							rezultat = operatii.inmultire(operatii.getPolA(), operatii.getPolB());
							view.setText("S-a selectat Inmultire!");
						}
						if (rezultat.toString().equals("")) {
							view.showError("Eroare la rezultat!");
						} else {
							view.setTextPolinom("Rezultat = ", rezultat);
						}
					} else if (nrPolinom >= 1) {
						if (selected == names[4]) {
							rezultat = operatii.derivare(operatii.getPolA());
							view.setText("S-a selectat Derivare!");
						} else if (selected == names[5]) {
							rezultat = operatii.integrare(operatii.getPolA());
							view.setText("S-a selectat Integrare!");
						}
						if (rezultat.toString().equals("")) {
							view.showError("Eroare la rezultat!");
						} else {
							view.setTextPolinom("Rezultat = ", rezultat);
						}
					} else {
						view.showError("Operatia este invalida, reintroduceti polinomul!");
						resetAllIntermediates();
					}
				} catch (NullPointerException exc) {}
				resetAllIntermediates();
			} else {
				view.showError("Adauga intai polinom, apoi efectueaza operatia");
			}
		}
	}
}
