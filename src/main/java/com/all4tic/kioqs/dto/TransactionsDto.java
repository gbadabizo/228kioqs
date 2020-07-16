package com.all4tic.kioqs.dto;

import javax.persistence.Column;

public class TransactionsDto {
	private long idtransaction;
	private String codetrans ;
	private String phone ;
	private String operateur ; //FLOOZ ou T-MONEY
	private String txReference ; // envoyé par paygate
	private int statusPayAsk ; // status de la demande de paiement
	public TransactionsDto(long idtransaction, String codetrans, String phone, String operateur, String txReference,
			int statusPayAsk) {
		super();
		this.idtransaction = idtransaction;
		this.codetrans = codetrans;
		this.phone = phone;
		this.operateur = operateur;
		this.txReference = txReference;
		this.statusPayAsk = statusPayAsk;
	}
	public TransactionsDto() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "TransactionsDto [idtransaction=" + idtransaction + ", codetrans=" + codetrans + ", phone=" + phone
				+ ", operateur=" + operateur + ", txReference=" + txReference + ", statusPayAsk=" + statusPayAsk + "]";
	}
	

}
