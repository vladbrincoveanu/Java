package model;

public class Produs {
	private int id;
	private String name;

	public Produs(int id, String name){
		this.id=id;
		this.name=name;
	}
	
	public Produs(String name){
		this.name=name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Produs [id=" + id + ", name=" + name;
	}
}
