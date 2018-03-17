package model;

public class Stoc {
	private int idProdus;
	private int cantitate;
	
	public Stoc(int idProdus, int cantitate){
		this.idProdus= idProdus;
		this.cantitate=cantitate;
	}
	
	public Stoc(int cantitate){
		this.cantitate=cantitate;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	
}
