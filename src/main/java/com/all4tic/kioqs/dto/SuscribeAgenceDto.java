package com.all4tic.kioqs.dto;

import java.time.LocalDate;



public class SuscribeAgenceDto {
	private long idsuscribeagence ;
	private String  codeLecteur ;
	private String  agence  ;
	private LocalDate datedeb ;
	private LocalDate datefin ;
	private int status ;
	public SuscribeAgenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuscribeAgenceDto(long idsuscribeagence, String codeLecteur, String agence, LocalDate datedeb,
			LocalDate datefin, int status) {
		super();
		this.idsuscribeagence = idsuscribeagence;
		this.codeLecteur = codeLecteur;
		this.agence = agence;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.status = status;
	}
	public long getIdsuscribeagence() {
		return idsuscribeagence;
	}
	public void setIdsuscribeagence(long idsuscribeagence) {
		this.idsuscribeagence = idsuscribeagence;
	}
	public String getCodeLecteur() {
		return codeLecteur;
	}
	public void setCodeLecteur(String codeLecteur) {
		this.codeLecteur = codeLecteur;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public LocalDate getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(LocalDate datedeb) {
		this.datedeb = datedeb;
	}
	public LocalDate getDatefin() {
		return datefin;
	}
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
