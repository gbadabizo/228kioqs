package com.all4tic.kioqs.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AgenceAbonnement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idagabn ;
	private String code ;
	private int montant ;
	private int montantext;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idagence")
	private Agence agence;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idabon")
	private Abonnement abonnement ;
	private int status =1 ;
	public AgenceAbonnement(int idagabn, String code, int montant, Agence agence, Abonnement abonnement, int status) {
		super();
		this.idagabn = idagabn;
		this.code = code;
		this.montant = montant;
		this.agence = agence;
		this.abonnement = abonnement;
		this.status = status;
	}
	
	public int getMontantext() {
		return montantext;
	}

	public void setMontantext(int montantext) {
		this.montantext = montantext;
	}

	public AgenceAbonnement() {
		super();
		// TODO Auto-generated constructor stub
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
	@JsonIgnore
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
