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
public class AgenceAbonnement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idagabn ;
	private String code ;
	private int montant ;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idagence")
	private Agence agence;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idabon")
	private Abonnement abonnement ;
	private int status =1 ;
	public AgenceAbonnement(long idagabn, String code, int montant, Agence agence, Abonnement abonnement, int status) {
		super();
		this.idagabn = idagabn;
		this.code = code;
		this.montant = montant;
		this.agence = agence;
		this.abonnement = abonnement;
		this.status = status;
	}
	public AgenceAbonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdagabn() {
		return idagabn;
	}
	public void setIdagabn(long idagabn) {
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
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
