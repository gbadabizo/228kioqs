package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.all4tic.kioqs.utilities.Utility;
@Entity
public class Suscribe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idsuscribe ;
	@NotNull
	@Column(unique = true)
	private String code =""+Utility.generateRandomDigits(6);
	private LocalDate datedeb ;
	private LocalDate datefin ;
	private int statuspay=1;// par defaut 1  0 kan c'est payé 
	private int status =1;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idlecteur")
	private Lecteur lecteur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idagenceabn")
	private AgenceAbonnement agenceabonnement;
	public Suscribe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suscribe(long idsuscribe, @NotNull String code, LocalDate datedeb, LocalDate datefin, int statuspay,
			int status, Lecteur lecteur, AgenceAbonnement agenceabonnement) {
		super();
		this.idsuscribe = idsuscribe;
		this.code = code;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.statuspay = statuspay;
		this.status = status;
		this.lecteur = lecteur;
		this.agenceabonnement = agenceabonnement;
	}
	public long getIdsuscribe() {
		return idsuscribe;
	}
	public void setIdsuscribe(long idsuscribe) {
		this.idsuscribe = idsuscribe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public int getStatuspay() {
		return statuspay;
	}
	public void setStatuspay(int statuspay) {
		this.statuspay = statuspay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Lecteur getLecteur() {
		return lecteur;
	}
	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	public AgenceAbonnement getAgenceabonnement() {
		return agenceabonnement;
	}
	public void setAgenceabonnement(AgenceAbonnement agenceabonnement) {
		this.agenceabonnement = agenceabonnement;
	}
	
	

}
