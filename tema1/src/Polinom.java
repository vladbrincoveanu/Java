import java.util.ArrayList;

public class Polinom {

	/**
	 * strucutra de date in care se pastreaza monoamele
	 *
	 */	
	private ArrayList<Monom> monoame = new ArrayList<Monom>();

	/**
	 * contructorul care primeste ca si parametru un array de monoame
	 *
	 */
	public Polinom(Monom[] a) {
		for (Monom m : a) {
			monoame.add(m);
		}
	}

	/**
	 * contructorul care primeste ca si parametru un monom
	 *
	 */
	public Polinom(Monom a) {
		monoame.add(a);
	}

	/**
	 * contructorul deafult
	 *
	 */
	public Polinom() {

	}

	/**
	 * getter pentru lsita de monoame
	 *
	 */
	public ArrayList<Monom> getMonoame() {
		return monoame;
	}

	/**
	 * se va adauga prin adunare monomul primit ca si parametru
	 * acestui polinom
	 */
	public void adaugaAdd(Monom b) {
		if (b.getCoef() != 0) {
			for (Monom a : monoame) {
				if (a.getPutere() == b.getPutere()) {
					monoame.remove(a);
					if (a.aduna(b) != null) {
						monoame.add(a.aduna(b));
					}
					return;
				}
			}
			monoame.add(b);
		}
	}
	
	/**
	 * se va adauga prin scadere monomul primit ca si parametru
	 * acestui polinom
	 */
	public void adaugaDiff(Monom b) {
		if (b.getCoef() != 0) {
			for (Monom a : monoame) {
				if (a.getPutere() == b.getPutere()) {
					monoame.remove(a);
					if (a.aduna(b) != null) {
						monoame.add(a.aduna(b));
					}
					return;
				}
			}
			monoame.add(b);
		}
	}

	/**
	 * se va adauga prin inmultire monomul primit ca si parametru
	 * acestui polinom
	 */
	public void adaugaInmultit(Monom b) {
		if (b.getCoef() != 0) {
			for (Monom a : monoame) {
				if (a.getPutere() == b.getPutere()) {
					monoame.remove(a);
					monoame.add(a.inmultit(b));
					return;
				}
			}
			monoame.add(b);
		}
	}

	/**
	 * returneaza valoarea gradului maxim din acest polinom
	 */
	public int gradMax() {
		int max = 0;

		for (Monom a : monoame) {
			if (a.getPutere() > max) {
				max = a.getPutere();
			}
		}
		return max;
	}

	/**
	 * returneaza monomul cu grad maxim din acest polinom
	 */
	public Monom monomMax() {
		int max = gradMax();

		for (Monom a : monoame) {
			if (a.getPutere() == max) {
				return a;
			}
		}
		return null;
	}

	/**
	 * returneaza acest polinomul inmultit cu monomul dat
	 * prin parametru
	 */
	public Polinom inmultireCuMonom(Monom b) {

		Polinom c = new Polinom();

		for (Monom a : monoame) {
			c.adaugaAdd(a);
		}

		for (Monom a : monoame) {
			c.getMonoame().remove(a);
			c.getMonoame().add(a.inmultit(b));

		}
		return c;
	}

	/**
	 * afisare polinom(doar pentru debugg)
	 */
	public void afisare() {

		for (Monom a : monoame) {
			System.out.print(a);
		}
		System.out.println();
	}

	/**
	 * suprascriere toString() din clasa Object,astfel:
	 * -se returneaza 0,daca monomul e null
	 * -se concateneaza toate monoamele.toString() 
	 * -daca la primul monom avem caracterul'+',el se sterge
	 */
	public String toString() {
		String s = "";
		for (Monom a : monoame) {
			s = s + a.toString();
		}
		if (s.equals("")) {
			s = "0";
		}
		if (s.charAt(0) == '+') {
			s = s.substring(1);
		}
		return s;
	}

}
