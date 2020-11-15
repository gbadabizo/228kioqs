package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SuscribeAgence implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idsuscribeagence ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idlecteur")
	private Lecteur lecteur ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idagence")
	private Agence agence  ;
	private LocalDate datedeb ;
	private LocalDate datefin ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idsuscribe")
	private Suscribe lastsuscribe ;
	private int status=1 ;
	public SuscribeAgence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuscribeAgence(long idsuscribeagence, Lecteur lecteur, Agence agence, LocalDate datedeb,
			LocalDate datefin, Suscribe lastsuscribe, int status) {
		super();
		this.idsuscribeagence = idsuscribeagence;
		this.lecteur = lecteur;
		this.agence = agence;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.lastsuscribe = lastsuscribe;
		this.status = status;
	}
	public long getIdsuscribeagence() {
		return idsuscribeagence;
	}
	public void setIdsuscribeagence(long idsuscribeagence) {
		this.idsuscribeagence = idsuscribeagence;
	}
	
	public Lecteur getLecteur() {
		return lecteur;
	}
	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
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
	public Suscribe getLastsuscribe() {
		return lastsuscribe;
	}
	public void setLastsuscribe(Suscribe lastsuscribe) {
		this.lastsuscribe = lastsuscribe;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	
}
