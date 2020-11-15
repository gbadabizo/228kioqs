package com.all4tic.kioqs.dto;

public class AgenceAbonnementDto {
	private int idagabn ;
	private String code ;
	private int montant ;
	private int montantext ;
	private int  idagence;
	private int  idabonnement ;
	private String libabonnement ;
	private String nomagence ;
	public AgenceAbonnementDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AgenceAbonnementDto(int idagabn, String code, int montant, int montantext, int idagence, int idabonnement,
			String libabonnement, String nomagence) {
		super();
		this.idagabn = idagabn;
		this.code = code;
		this.montant = montant;
		this.montantext = montantext;
		this.idagence = idagence;
		this.idabonnement = idabonnement;
		this.libabonnement = libabonnement;
		this.nomagence = nomagence;
	}

	public int getIdagabn() {
		return idagabn;
	}

	public void setIdagabn(int idagabn) {
		this.idagabn = idagabn;
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
	public int getMontantext() {
		return montantext;
	}
	public void setMontantext(int montantext) {
		this.montantext = montantext;
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
	public String getLibabonnement() {
		return libabonnement;
	}
	public void setLibabonnement(String libabonnement) {
		this.libabonnement = libabonnement;
	}
	public String getNomagence() {
		return nomagence;
	}
	public void setNomagence(String nomagence) {
		this.nomagence = nomagence;
	}
	
}
