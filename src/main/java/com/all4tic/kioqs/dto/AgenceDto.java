package com.all4tic.kioqs.dto;



public class AgenceDto {
	private int idagence;
	private String nom ;
    private String code ;
	private String description;
	private String adresse ;
	private String periodicite;
	private String email ;
	private String telephone1;
	private String telephone2;
	private String numFlooz ;
	private String numTmoney;
	private double prixUnit ;
	private int status=1;
	private  int idCategorie ;
	public AgenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgenceDto(int idagence, String nom, String code, String description, String adresse, String email,
			String telephone1, String telephone2, String numFlooz, String numTmoney, double prixUnit, int status,
			int idCategorie) {
		super();
		this.idagence = idagence;
		this.nom = nom;
		this.code = code;
		this.description = description;
		this.adresse = adresse;
		this.email = email;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		this.numFlooz = numFlooz;
		this.numTmoney = numTmoney;
		this.prixUnit = prixUnit;
		this.status = status;
		this.idCategorie = idCategorie;
	}
	public int getIdagence() {
		return idagence;
	}
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getNumFlooz() {
		return numFlooz;
	}
	public void setNumFlooz(String numFlooz) {
		this.numFlooz = numFlooz;
	}
	public String getNumTmoney() {
		return numTmoney;
	}
	public void setNumTmoney(String numTmoney) {
		this.numTmoney = numTmoney;
	}
	public double getPrixUnit() {
		return prixUnit;
	}
	public void setPrixUnit(double prixUnit) {
		this.prixUnit = prixUnit;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	@Override
	public String toString() {
		return "AgenceDto [idagence=" + idagence + ", nom=" + nom + ", code=" + code + ", description=" + description
				+ ", adresse=" + adresse + ", email=" + email + ", telephone1=" + telephone1 + ", telephone2="
				+ telephone2 + ", numFlooz=" + numFlooz + ", numTmoney=" + numTmoney + ", prixUnit=" + prixUnit
				+ ", status=" + status + ", idCategorie=" + idCategorie + "]";
	}
	public String getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}
	
	
}
