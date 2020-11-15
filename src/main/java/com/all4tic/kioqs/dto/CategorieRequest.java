package com.all4tic.kioqs.dto;

public class CategorieRequest {
	private String  libelle; 
	private String description;
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategorieRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieRequest(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}
	
}
