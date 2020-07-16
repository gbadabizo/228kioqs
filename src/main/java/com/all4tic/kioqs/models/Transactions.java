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
@Entity
public class Transactions implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idtransaction;
	@Column(unique=true)
	private String codetrans ;
	private String phone ;
	private String operateur ; //FLOOZ ou T-MONEY
	private String txReference ; // envoyé par paygate
	private int statusPayAsk= 1 ; // status de la demande de paiement 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idparution")
	Parution parution;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlecteur")
	Lecteur lecteur ;
	private LocalDate dateop= LocalDate.now();
	private int statusPay=1; // statut apres l'operation
	private int status =1;
	public Transactions(long idtransaction, String identifant, String phone, String operateur, String txReference,
			int statusPayAsk, Parution parution, Lecteur lecteur, int status) {
		super();
		this.idtransaction = idtransaction;
		this.codetrans = identifant;
		this.phone = phone;
		this.operateur = operateur;
		this.txReference = txReference;
		this.statusPayAsk = statusPayAsk;
		this.parution = parution;
		this.lecteur = lecteur;
		this.status = status;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transactions(long idtransaction, String codetrans, String phone, String operateur, String txReference,
			int statusPayAsk, Parution parution, Lecteur lecteur, int statusPay, int status) {
		super();
		this.idtransaction = idtransaction;
		this.codetrans = codetrans;
		this.phone = phone;
		this.operateur = operateur;
		this.txReference = txReference;
		this.statusPayAsk = statusPayAsk;
		this.parution = parution;
		this.lecteur = lecteur;
		this.statusPay = statusPay;
		this.status = status;
	}
	
	public int getStatusPay() {
		return statusPay;
	}
	public void setStatusPay(int statusPay) {
		this.statusPay = statusPay;
	}
	public long getIdtransaction() {
		return idtransaction;
	}
	public void setIdtransaction(long idtransaction) {
		this.idtransaction = idtransaction;
	}
	
	public String getCodetrans() {
		return codetrans;
	}
	public void setCodetrans(String codetrans) {
		this.codetrans = codetrans;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getTxReference() {
		return txReference;
	}
	public void setTxReference(String txReference) {
		this.txReference = txReference;
	}
	public int getStatusPayAsk() {
		return statusPayAsk;
	}
	public void setStatusPayAsk(int statusPayAsk) {
		this.statusPayAsk = statusPayAsk;
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
	@Override
	public String toString() {
		return "Transactions [idtransaction=" + idtransaction + ", codetrans=" + codetrans + ", phone=" + phone
				+ ", operateur=" + operateur + ", txReference=" + txReference + ", statusPayAsk=" + statusPayAsk
				+ ", parution=" + parution + ", lecteur=" + lecteur + ", status=" + status + "]";
	}
	

}
