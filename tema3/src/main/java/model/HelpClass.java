package model;

public class HelpClass {

	private int id;
	private String nameProdus;
	private int cantitate;
	
	public HelpClass(int id, String name,int cantitate) {
		super();
		this.id = id;
		this.nameProdus = name;
		this.cantitate = cantitate;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return nameProdus;
	}
	public void setName(String name) {
		this.nameProdus = name;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
}
