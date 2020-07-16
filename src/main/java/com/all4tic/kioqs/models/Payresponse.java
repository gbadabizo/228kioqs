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
public class Payresponse implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idpayresponse ;
	////Code de référence de paiement généré par Flooz/TMoney.
	//Ce code peut être utilisé en cas de résolution de problèmes ou de plaintes.
	@Column(unique=true)
	private String payref; 
	private LocalDate datepay ;
	private int statuspay; //0 : Paiement réussi avec succès 2 : En cours 4 : Expiré 6: Annulé
	private String txreference;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtransaction")
	private Transactions transactions ;
	private String methodpay ; // FLOOZ ou TMONEY
	public Payresponse(long idpayresponse, String payref, LocalDate datepay, int statuspay, String txreference,
			Transactions transactions, String methodpay) {
		super();
		this.idpayresponse = idpayresponse;
		this.payref = payref;
		this.datepay = datepay;
		this.statuspay = statuspay;
		this.txreference = txreference;
		this.transactions = transactions;
		this.methodpay = methodpay;
	}
	public Payresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdpayresponse() {
		return idpayresponse;
	}
	public void setIdpayresponse(long idpayresponse) {
		this.idpayresponse = idpayresponse;
	}
	public String getPayref() {
		return payref;
	}
	public void setPayref(String payref) {
		this.payref = payref;
	}
	public LocalDate getDatepay() {
		return datepay;
	}
	public void setDatepay(LocalDate datepay) {
		this.datepay = datepay;
	}
	public int getStatuspay() {
		return statuspay;
	}
	public void setStatuspay(int statuspay) {
		this.statuspay = statuspay;
	}
	public String getTxreference() {
		return txreference;
	}
	public void setTxreference(String txreference) {
		this.txreference = txreference;
	}
	public Transactions getTransactions() {
		return transactions;
	}
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	public String getMethodpay() {
		return methodpay;
	}
	public void setMethodpay(String methodpay) {
		this.methodpay = methodpay;
	}
	
	
	
}
