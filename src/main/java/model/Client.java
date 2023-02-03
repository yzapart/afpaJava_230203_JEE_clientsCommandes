package model;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;

	public Client() {
	}

	public Client(String nom, String prenom, String adresse, String telephone, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getEmail() {
		return email;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client  [nom = " + nom + "]";
	}

}
