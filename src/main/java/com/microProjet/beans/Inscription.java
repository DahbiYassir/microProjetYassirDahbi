package com.microProjet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="clients")
public class Inscription {
	@Id //@GeneratedValue( strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nom, prenom, adresse, email, motPasse;
	private int tel;

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motPasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motPasse = motDePasse;
	}

	public Inscription(String adresse, String email, String motDePasse,String nom, String prenom, int tel,int id) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.motPasse = motDePasse;
		this.tel = tel;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

}
