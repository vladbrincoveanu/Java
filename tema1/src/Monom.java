import java.text.DecimalFormat;

/**
 * @author Brincoveanu Vasile Vlad
 *
 */

public class Monom {

	private double coef = 0;
	private int putere = 0;

	
	public Monom(double coef, int putere) {
		this.coef = coef;
		this.putere = putere;
	}
	
	/**
	 * returneaza variabila instanta putere a unui obiect instantiat
	 */
	public int getPutere() {
		return putere;
	}
	
	/**
	 * returneaza variabila instanta coeficient a unui obiect 
	 * instantiat
	 */
	public double getCoef() {
		return coef;
	}
	
	/**
	 * returneaza suma coeficientilor acestui monom cu monomul dat 
	 * prin parametru
	 */
	public double addCoef(Monom b) {
		return this.getCoef() + b.getCoef();

	}

	/**
	 * returneaza diferenta coeficientilor acestui monom cu monomul
	 *  dat prin parametru
	 */
	public double subCoef(Monom b) {
		return this.getCoef() - b.getCoef();

	}
	
	/**
	 * returneaza suma puterilor acestui monom cu monomul dat prin
parametru
	 */
	public int addPutere(Monom b) {
		return this.getPutere() + b.getPutere();
	}

	/**
	 * returneaza produsul coeficientilor acestui monom cu monomul 
	 * dat prin parametru
	 */
	public double multCoef(Monom b) {
		return this.getCoef() * b.getCoef();
	}

	/**
	 * returneaza un nou monom,care are ca si coeficient, suma 
	 * coeficientilor acestui monom cu monomul dat
	 * si aceeasi putere,doar daca suma coeficientilor e diferita 
	 * de 0,altfel returneaza null 
	 */
	public Monom aduna(Monom b) {
		if (this.coef + b.coef != 0) {
			return new Monom(this.coef + b.coef, this.putere);
		}
		return null;
	}

	/**
	 * returneaza un nou monom,care are ca si coeficient, 
	 * diferenta coeficientilor acestui monom cu monomul dat
	 * si aceeasi putere,doar daca diferenta coeficientilor 
	 * este diferita de 0,altfel returneaza null 
	 */
	public Monom scade(Monom b) {
		if (this.coef - b.coef != 0) {
			return new Monom(this.coef - b.coef, this.putere);
		}
		return null;
	}

	/**
	 * returneaza un nou monom, care are ca si coeficient, 
	 * produsul coeficientilor acestui monom cu monomul dat
	 * si ca si putere, suma coeficientilor dintre cele doua monoae
	 */
	public Monom inmultit(Monom b) {
		return new Monom(this.coef * b.coef, this.putere + b.putere);
	}
	
	/**
	 * returneaza un nou monom,care are ca si coeficient,
	 * impartirea coeficientilor acestui monom cu monomul dat
	 * si ca si putere,diferenta coeficientilor dintre 
	 * cele doua monoame
	 */
	public Monom imparte(Monom b) {
		return new Monom(this.coef / b.coef, this.putere - b.putere);
	}

	/**
	 * returneaza un nou monom, care are ca si coeficient, 
	 * produsul dintre coeficientul si puterea acestui monom,
	 * si ca si putere, puterea monomului-1
	 */
	public Monom deriveaza() {
		return new Monom(this.coef * this.putere, this.putere - 1);
	}
	
	/**
	 * returneaza un nou monom, care are ca si coeficient, 
	 * impartirea dintre coeficientul si puterea acestui monom,
	 * si ca si putere, puterea monomului+1
	 */
	public Monom integreaza() {
		return new Monom(this.coef / (this.putere + 1), this.putere + 1);
	}
	
	/**
	 * S-a suprascris metoda toString() din clasa Object pentru o 
	 * mai buna formatare la aparitia pe ecran,astfel 
	 * s-au luat in considerare urmatoarele lucruri:
	 * -daca coeficientul este 0 se va returna blank;
	 * -daca coeficientul este 1 se vor returna caracterele 'x'.'^',urmate 
	 * de valoarea puterii;
	 * -daca puterea este 0 se va returna o aproximare cu 2 zecimale a 
	 * coeficientului;
	 * -daca puterea este 1 se va returna o aproximare cu 2 zecimale a 
	 * coeficientului + caracterul 'x';
	 */
	public String toString() {
		String s = "";
		double e = 0.0001;
		if (this.coef == 0) {
			return "";
		}

		if (this.putere == 0) {
			if (this.coef > 0) {
				if (Math.abs(this.coef - (int) this.coef) < e) {
					return "+" + (int) this.coef;
				} else {
					return "+" + new DecimalFormat("##.##").format(this.coef);
				}
			} else {
				return "" + new DecimalFormat("##.##").format(this.coef);
			}
		}

		if (this.coef == 1) {
			if (this.putere != 1)
				s = "+x^" + this.putere;
			else {
				s = "+x";
			}
		} else {
			if (this.coef > 1) {
				if (Math.abs(this.coef - (int) this.coef) < e) {
					if (this.putere > 1) {
						s = "+" + (int) this.coef + "x^" + this.putere;
					} else {
						s = "+" + (int) this.coef + "x";
					}
				} else {

					if (this.putere > 1) {
						s = "+" + new DecimalFormat("##.##").format(this.coef) + "x^" + this.putere;
					} else {
						s = "+" + new DecimalFormat("##.##").format(this.coef) + "x";
					}
				}

			} else {
				if (Math.abs(this.coef - (int) this.coef) < e) {
					if (this.putere > 1) {
						s = (int) this.coef + "x^" + this.putere;
					} else {
						s = (int) this.coef + "x";
					}
				} else {
					if (this.putere > 1) {
						s = new DecimalFormat("##.##").format(this.coef) + "x^" + this.putere;
					} else {
						s = new DecimalFormat("##.##").format(this.coef) + "x";
					}
				}
			}
		}
		return s;
	}

	public Monom negat() {
		return new Monom(-this.coef, this.putere);
	}

}
