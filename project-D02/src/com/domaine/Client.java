package com.domaine;

import java.io.Serializable;

public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String poste;

	public Client() {
		super();
	}


	public Client(String nom, String prenom, String adresse, String poste) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.poste = poste;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", poste=" + poste
				+ "]";
	}

	
	

}
