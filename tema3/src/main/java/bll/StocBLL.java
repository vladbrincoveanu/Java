package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import bll.validators.CantitateUpdateValidator;
import bll.validators.Validator;
import dao.StocDAO;
import model.Stoc;

public class StocBLL {
	/**
	 * arraylsit ce itereaza prin toti validatorii pentru a
	 * testa obiectul
	 */
	private List<Validator<Stoc>> validators;

	/**
	 * contructor
	 */
	public StocBLL() {
		validators = new ArrayList<Validator<Stoc>>();
		validators.add(new CantitateUpdateValidator());
	}

	/**
	 * gaseste stocul dupa nume din table produs
	 * @param name
	 * @return id-ul gasit
	 */
	public int findStocById(String name) {
		int st = StocDAO.findByName(name);
		if (st < 0) {
			throw new NoSuchElementException("The produs with name =" + name + " was not found!");
		}
		return st;
	}

	/**
	 * apeleaza din logica de mai jos metoda pentru a
	 * arata toate stocurile
	 * @return arrylist de stoc-uri
	 */
	public ArrayList<Stoc> showStocInfo(){
		//for(int i=0; i < StudentDAO.showClientInfo().size(); i++)
		//	System.out.println("TESTING"+StudentDAO.showClientInfo().get(i));
		return StocDAO.showInfo();
	}

	/**
	 * insereaza un obiect de tipul stoc
	 * @param stoc
	 * @return id-ul stocului inserat
	 */
	public int insertStoc(Stoc stoc) {
		for (Validator<Stoc> v : validators) {
			v.validate(stoc);
		}
		return StocDAO.insert(stoc);
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public int deleteStoc(int id){
		return StocDAO.delete(id);
	}
	
	public int updateStoc(Stoc stoc) {
		for (Validator<Stoc> v : validators) {
			v.validate(stoc);
		}
		return StocDAO.update(stoc);
	}
}
