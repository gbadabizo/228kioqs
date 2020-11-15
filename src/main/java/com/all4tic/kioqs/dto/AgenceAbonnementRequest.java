package com.all4tic.kioqs.dto;



public class AgenceAbonnementRequest {
	private String code ;
	private int montant ;
	private int montantext ;
	private int  idagence;
	private int  idabonnement ;
	public AgenceAbonnementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgenceAbonnementRequest(String code, int montant, int idagence, int idabonnement) {
		super();
		this.code = code;
		this.montant = montant;
		this.idagence = idagence;
		this.idabonnement = idabonnement;
	}
	
	public int getMontantext() {
		return montantext;
	}
	public void setMontantext(int montantext) {
		this.montantext = montantext;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getIdagence() {
		return idagence;
	}
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	public int getIdabonnement() {
		return idabonnement;
	}
	public void setIdabonnement(int idabonnement) {
		this.idabonnement = idabonnement;
	}
	
}
