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
public class LecteurAgence implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idlecteuragence;
	private LocalDate datedeb;
	private LocalDate datefin ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idlecteur")
	private Lecteur lecteur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idagence")
	private Agence agence;
	private int status =1 ;
	public LecteurAgence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LecteurAgence(long idlecteuragence, LocalDate datedeb, LocalDate datefin, Lecteur lecteur, Agence agence,
			int status) {
		super();
		this.idlecteuragence = idlecteuragence;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.lecteur = lecteur;
		this.agence = agence;
		this.status = status;
	}
	public long getIdlecteuragence() {
		return idlecteuragence;
	}
	public void setIdlecteuragence(long idlecteuragence) {
		this.idlecteuragence = idlecteuragence;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
