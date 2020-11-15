package com.all4tic.kioqs.dto;

public class ZoneRequest {
	private int idzone;
	private String libelle;
	public ZoneRequest(int idzone, String libelle) {
		super();
		this.idzone = idzone;
		this.libelle = libelle;
	}
	public ZoneRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdzone() {
		return idzone;
	}
	public void setIdzone(int idzone) {
		this.idzone = idzone;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
