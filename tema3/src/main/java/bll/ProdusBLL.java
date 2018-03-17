package bll;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import dao.ProdusDAO;
import model.Produs;

public class ProdusBLL {

	/**
	 *
	 */
	public ProdusBLL() {
	
	}

	public Produs findProdusById(int id) {
		Produs st = ProdusDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The produs with id =" + id + " was not found!");
		}
		return st;
	}
	
	public ArrayList<Produs> showProdusInfo(){
		return ProdusDAO.showInfo();
	}

	public int insertProdus(Produs produs) {
		return ProdusDAO.insert(produs);
	}
	
	public int deleteProdus(int id){
		return ProdusDAO.delete(id);
	}
	
	public int updateProdus(Produs student) {
		return ProdusDAO.update(student);
	}
}
