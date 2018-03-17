import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {
	/**
	 * contine toti coeficienti din parsarea string-ului
	 * dat de utilizator 
	 */
	private ArrayList<Integer> coef;
	/**
	 * contine toate puteriile din parsarea string-ului
	 * dat de utilizator 
	 */
	private ArrayList<Integer> putere;
	/**
	 *olinomul rest din impartirea a doua polinoame
	 */
	private Polinom rest;
	
	/**
	*primul polinom care va fi populat cu monoame formate din
	*coeficienti si puteri luate din ArrayListurile anterioare
	*/
	private Polinom a = new Polinom();
	
	/**
	*al doile polinom care va fi populat cu monoame formate din
	*coeficienti si puteri luate din ArrayListurile anterioare
	*/
	private Polinom b = new Polinom();
	
	/**
	 * iteratorii sunt folositi pentru a popula polinoamele
	 * cu monoame  formate din coeficienti si puteri luate din ArrayListurile anterioare
	 */
	private Iterator<Integer> i1, i2;

	/**
	 *se returneaza un nou polinom format de pe urma adunarii celor 
	 *doua polinoame(se folosesc metodele de adauga din clasa Polinom)
	 */
	public Polinom adunare(Polinom a, Polinom b) {

		Polinom c = new Polinom();

		for (Monom unu : a.getMonoame()) {
			c.adaugaAdd(unu);
		}

		for (Monom doi : b.getMonoame()) {
			c.adaugaAdd(doi);
		}

		return c;
	}

	/**
	 *se returneaza un nou polinom format de pe urma scaderii celor 
	 *doua polinoame(se folosesc metodele de adauga din clasa Polinom,
	 *precum si metoda de negat din clasa Monom)
	 */
	public Polinom scadere(Polinom a, Polinom b) {

		Polinom c = new Polinom();

		for (Monom unu : a.getMonoame()) {
			c.adaugaDiff(unu);
		}

		for (Monom doi : b.getMonoame()) {
			c.adaugaDiff(doi.negat());
		}

		return c;
	}

	/**
	 *se returneaza un nou polinom format de pe urma inmultirii celor 
	 *doua polinoame(se folosesc metodele de adauga din clasa Polinom,
	 *precum si metoda de inmultit din clasa Monom)
	 */
	public Polinom inmultire(Polinom a, Polinom b) {

		Polinom c = new Polinom();

		for (Monom unu : a.getMonoame()) {
			for (Monom doi : b.getMonoame()) {
				c.adaugaAdd(unu.inmultit(doi));
			}
		}
		return c;
	}

	/**
	 *se returneaza un nou polinom(catul) format de pe urma impartirii celor 
	 *doua polinoame(se folosesc metodele de adauga,inmultire,grad max din clasa Polinom,
	 *precum si getCoef din clasa Monom)
	 */
	public Polinom impartire(Polinom d, Polinom i) {

		Polinom cat = new Polinom();
		Polinom aux = new Polinom();
		int k = 0;
		while (d.gradMax() > i.gradMax()
				|| ((d.gradMax() == i.gradMax()) && d.monomMax().getCoef() / i.monomMax().getCoef() != 0)) {
			Monom rez = d.monomMax().imparte(i.monomMax());
			aux = i.inmultireCuMonom(rez);
			cat.adaugaAdd(rez);
			d = scadere(d, aux);
			if (k > 100000) {
				break;
			}
			k++;
		}
		rest = d;
		return cat;
	}

	/**
	 * se returneaza un nou polinom format de pe urma derivarii polinomului 
	 * (se folosesc metodele de adauga din clasa Polinom,precum si metode de 
	 * derivare din calsa Monom)
	 */
	public Polinom derivare(Polinom a) {

		Polinom c = new Polinom();

		for (Monom x : a.getMonoame()) {
			c.adaugaAdd(x.deriveaza());
		}

		return c;
	}

	/**
	 * se returneaza un nou polinom format de pe urma derivarii polinomului 
	 * (se folosesc metodele de adauga din clasa Polinom,precum si metode de 
	 * integrare din calsa Monom)
	 */
	public Polinom integrare(Polinom a) {

		Polinom c = new Polinom();

		for (Monom x : a.getMonoame()) {
			c.adaugaAdd(x.integreaza());
		}

		return c;
	}

	/**
	 * se parseaza string-ul dat de utilizator si se populeaza 
	 * arraylist-urile de coeficienti si puteri + multe verificari 
	 * spre a corecta si simplifica scrierea polinoamelor
	 */
	public void regexChecker(String check){
		// [x-]?(-?\\d)[xX]\\^(-?\\d+)
		//// ([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))
		// "?:((-?\\b\\d+)[xX]\\^(-?\\d+\\b))|?:(([x-])?[xX]\\^(-?\\d+\\b))|?:((-?\\d+\\b))"
		// String regex = "([+-]?[^-+]+)";
		String regex = "((?:(?:([+-]?\\d+)x\\^(\\d+))|(?:[+-]?x\\^(\\d+)))|(?:([+-]?\\d+)x)|(?:\\-?\\d+)|(?:[+-]?x))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(check.toLowerCase());
		coef = new ArrayList<Integer>();
		putere = new ArrayList<Integer>();

		while (m.find()) {
			if (m.group().length() != 0) {
				if (!(m.group(2) == null && m.group(3) == null)) {
					coef.add(Integer.parseInt(m.group(2)));
					putere.add(Integer.parseInt(m.group(3)));
				} else {
					if (!(m.group(4) == null)) {
						if (m.group(1).charAt(0) == '-') {
							coef.add(-1);
							putere.add(Integer.parseInt(m.group(4)));
						} else {
							coef.add(1);
							putere.add(Integer.parseInt(m.group(4)));
						}
					} else {
						if (!(m.group(5) == null)) {
							coef.add(Integer.parseInt(m.group(5)));
							putere.add(1);
						} else {
							if (m.group(1).contains("x")) {
								if (m.group(1).charAt(0) == '-') {
									coef.add(-1);
									putere.add(1);
								} else {
									coef.add(1);
									putere.add(1);
								}
							} else {
								coef.add(Integer.parseInt(m.group(1)));
								putere.add(0);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * reseteaza cele doua  polinoamele 
	 */
	public void reset() {
		a = new Polinom();
		b = new Polinom();
	}

	/**
	 * getter pentru al doilea polinom+crearea lui
	 */
	public Polinom getPolinomBFromParser() {
		i1 = coef.iterator();
		i2 = putere.iterator();
		while (i1.hasNext() && i2.hasNext()) {
			int x = i1.next();
			int y = i2.next();
			b.adaugaAdd(new Monom(x, y));
		}
		return b;
	}

	/**
	 * getter pentru primu polinom+crearea lui
	 */
	public Polinom getPolinomAFromParser() {
		i1 = coef.iterator();
		i2 = putere.iterator();
		while (i1.hasNext() && i2.hasNext()) {
			int x = i1.next();
			int y = i2.next();
			a.adaugaAdd(new Monom(x, y));
		}
		return a;
	}

	/**
	 * getter pentru primul polinom
	 */
	public Polinom getPolA() {
		return a;
	}

	/**
	 * getter pentru al doilea polinom
	 */
	public Polinom getPolB() {
		return b;
	}

	/**
	 * getter pentru polinomul rest al impartirii
	 */
	public String getRest() {
		return rest.toString();
	}
}
