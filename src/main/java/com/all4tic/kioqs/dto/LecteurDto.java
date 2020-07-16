package com.all4tic.kioqs.dto;


public class LecteurDto {
	private long idlecteur;
	private String nom ;
	private String prenoms;
	private String code ;
	private String telephone;
	private int status=1;
	private int isvalidated = 0 ;
	public LecteurDto(long idlecteur, String nom, String prenoms, String code, String telephone, int status,
			int isvalidated) {
		super();
		this.idlecteur = idlecteur;
		this.nom = nom;
		this.prenoms = prenoms;
		this.code = code;
		this.telephone = telephone;
		this.status = status;
		this.isvalidated = isvalidated;
	}
	public LecteurDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdlecteur() {
		return idlecteur;
	}
	public void setIdlecteur(long idlecteur) {
		this.idlecteur = idlecteur;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsvalidated() {
		return isvalidated;
	}
	public void setIsvalidated(int isvalidated) {
		this.isvalidated = isvalidated;
	}
	
}

