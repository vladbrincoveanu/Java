package model;

public class Comanda {
	private int idComanda;
	private int idStudent;
	private int idProdus;
	private int cantitate;

	public Comanda(int idComanda, int idStudent, int idProdus, int cantitate) {
		super();
		this.idComanda = idComanda;
		this.idStudent = idStudent;
		this.idProdus = idProdus;
		this.cantitate = cantitate;
	}

	public Comanda(int idStudent, int idProdus, int cantitate) {
		super();
		this.idStudent = idStudent;
		this.idProdus = idProdus;
		this.cantitate = cantitate;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

}
