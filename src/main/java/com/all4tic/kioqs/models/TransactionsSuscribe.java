package com.all4tic.kioqs.models;

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
public class TransactionsSuscribe {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idtransSuscribe;
	@Column(unique=true)
	private String codetrans ;
	private String phone ;
	private String operateur ; //FLOOZ ou T-MONEY
	private String txReference ; // envoyé par paygate
	private int statusPayAsk= 1 ; // status de la demande de paiement 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsuscribe")
	Suscribe suscribe;
	private LocalDate dateop= LocalDate.now();
	private int statusPay=1; // statut apres l'operation
	private int status =1;
	public TransactionsSuscribe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionsSuscribe(long idtransSuscribe, String codetrans, String phone, String operateur,
			String txReference, int statusPayAsk, Suscribe suscribe, LocalDate dateop, int statusPay, int status) {
		super();
		this.idtransSuscribe = idtransSuscribe;
		this.codetrans = codetrans;
		this.phone = phone;
		this.operateur = operateur;
		this.txReference = txReference;
		this.statusPayAsk = statusPayAsk;
		this.suscribe = suscribe;
		this.dateop = dateop;
		this.statusPay = statusPay;
		this.status = status;
	}
	public long getIdtransSuscribe() {
		return idtransSuscribe;
	}
	public void setIdtransSuscribe(long idtransSuscribe) {
		this.idtransSuscribe = idtransSuscribe;
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
	public Suscribe getSuscribe() {
		return suscribe;
	}
	public void setSuscribe(Suscribe suscribe) {
		this.suscribe = suscribe;
	}
	public LocalDate getDateop() {
		return dateop;
	}
	public void setDateop(LocalDate dateop) {
		this.dateop = dateop;
	}
	public int getStatusPay() {
		return statusPay;
	}
	public void setStatusPay(int statusPay) {
		this.statusPay = statusPay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
