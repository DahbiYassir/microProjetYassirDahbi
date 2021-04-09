package com.microProjet.beans;

public class Categorie {
	int id;
	String categorie;
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", categorie=" + categorie + "]";
	}
	public Categorie(int id, String categorie) {
		super();
		this.id = id;
		this.categorie = categorie;
	}
	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
