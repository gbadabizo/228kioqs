package com.all4tic.kioqs.dto;

public class RequestLecteur {
	private String nom ;
	private String prenoms;
	private String telephone;
	public RequestLecteur(String nom, String prenoms, String telephone) {
		super();
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
	}
	public RequestLecteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
