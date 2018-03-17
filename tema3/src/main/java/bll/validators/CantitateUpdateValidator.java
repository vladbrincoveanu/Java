package bll.validators;

import model.Stoc;

public class CantitateUpdateValidator implements Validator<Stoc>{

	/**
	 * verifica daca cantiatea este mai mare decat 0, daca nu arunca eroare
	 *
	 */
	public void validate(Stoc s) {

		if (s.getCantitate() < 0) {
			throw new IllegalArgumentException("Cantitatea insuficienta ");
		}

	}
}
