import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestClass {

	Monom[] a = { new Monom(1, 4), new Monom(-1, 3), new Monom(2, 2), new Monom(-1, 1), new Monom(3, 0) };
	Monom[] b = { new Monom(1, 1), new Monom(-1, 0) };
	Monom[] adunare = { new Monom(1, 4), new Monom(-1, 3), new Monom(2, 2), new Monom(2, 0) };
	Monom[] scadere = { new Monom(1, 4), new Monom(-1, 3), new Monom(2, 2), new Monom(-2, 1), new Monom(4, 0) };
	Monom[] inmultire = { new Monom(1, 5), new Monom(-2, 4), new Monom(3, 3), new Monom(-3, 2), new Monom(4, 1),
			new Monom(-3, 0) };
	Monom[] impartire = { new Monom(1, 3), new Monom(2, 1), new Monom(1, 0) };
	Monom[] derivare = { new Monom(4, 3), new Monom(-3, 2), new Monom(4, 1), new Monom(-1, 0) };
	Monom[] integrare = { new Monom(0.2, 5), new Monom(-0.25, 4), new Monom(0.66, 3), new Monom(-0.5, 2),
			new Monom(3, 1) };
	Polinom p1 = new Polinom(a);
	Polinom p2 = new Polinom(b);
	Operatii op = new Operatii();
	Polinom test;
	String StringtoTest ="x^4-x^3+2x^2-x+3";
	Iterator<Monom> i1, i2;

	/**
	 * testarea initializare polinom
	 */	
	@Test
	public void verificarePolinom() {
		test = new Polinom(a);
		i1 = p1.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}
	
	/**
	 * testarea adunare doua polinoame
	 */	
	@Test
	public void adunare() {
		test = new Polinom(adunare);
		Polinom rez = op.adunare(p1, p2);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}

	/**
	 * testarea scadere doua polinoame
	 */	
	@Test
	public void scadere() {
		test = new Polinom(scadere);
		Polinom rez = op.scadere(p1, p2);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}

	/**
	 * testarea inmultire doua polinoame
	 */	
	@Test
	public void inmultire() {
		test = new Polinom(inmultire);
		Polinom rez = op.inmultire(p1, p2);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}

	/**
	 * testarea impartire doua polinoame
	 */	
	@Test
	public void impartire() {
		test = new Polinom(impartire);
		Polinom rez = op.impartire(p1, p2);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}

	/**
	 * testarea derivare doua polinoame
	 */
	@Test
	public void derivare() {
		test = new Polinom(derivare);
		Polinom rez = op.derivare(p1);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0);
			assertEquals(test.getPutere(), rez1.getPutere(), 0);
		}
	}

	/**
	 * testarea integrare doua polinoame
	 */
	@Test
	public void integrare() {
		test = new Polinom(integrare);
		Polinom rez = op.integrare(p1);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0.01);
			assertEquals(test.getPutere(), rez1.getPutere(), 0.01);
		}
	}
	
	/**
	 * testarea parsare corecta din string in polinom
	 */
	@Test
	public void regexTester() {
		test = new Polinom(a);
		try {
			op.regexChecker(StringtoTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Polinom rez =op.getPolinomAFromParser();
		System.out.println(rez);
		i1 = rez.getMonoame().iterator();
		i2 = test.getMonoame().iterator();
		while (i1.hasNext() && i2.hasNext()) {
			Monom rez1 = i1.next();
			Monom test = i2.next();
			assertEquals(test.getCoef(), rez1.getCoef(), 0.01);
			assertEquals(test.getPutere(), rez1.getPutere(), 0.01);
		}
		
	}

}
