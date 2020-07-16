package com.all4tic.kioqs.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CheckParution implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idcheckparution ;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idparution")
	Parution parution;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlecteur")
	Lecteur lecteur ;
	int status=1;
	public CheckParution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckParution(long idcheckparution, Parution parution, Lecteur lecteur,
			int status) {
		super();
		this.idcheckparution = idcheckparution;
		this.parution = parution;
		this.lecteur = lecteur;
		this.status = status;
	}
	public long getIdcheckparution() {
		return idcheckparution;
	}
	public void setIdcheckparution(long idcheckparution) {
		this.idcheckparution = idcheckparution;
	}
	
	public Parution getParution() {
		return parution;
	}
	public void setParution(Parution parution) {
		this.parution = parution;
	}
	public Lecteur getLecteur() {
		return lecteur;
	}
	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
