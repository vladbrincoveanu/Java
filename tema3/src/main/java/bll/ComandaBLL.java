package bll;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import dao.ComandaDAO;
import model.Comanda;

public class ComandaBLL {

	/**
	 * contructorul clasei
	 */
	public ComandaBLL() {
	
	}

	/**
	 * gaseste o comanda dupa id si o ret
	 * @param id
	 * @return Comanda
	 */
	public Comanda findProdusById(int id) {
		Comanda st = ComandaDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The comanda with id =" + id + " was not found!");
		}
		return st;
	}

	/**
	 * Apeleaza logica de dedesubt a clasei ComandaDAO pentru a
	 * extrage toate comenziile intr-un arrayList pe care le va
	 * afisa mai apoi intr-un JTable
	 * @return
	 */
	public ArrayList<Comanda> showInfo(){
		return ComandaDAO.showInfo();
	}

	/**
	 * va apela logica din ComandaDA) pentru a insera un obiect
	 * de tipul Comanda
	 * @param comanda
	 * @return id comenzii inserate
	 */
	public int insertComanda(Comanda comanda) {
		return ComandaDAO.insert(comanda);
	}
}
