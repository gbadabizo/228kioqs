package com.all4tic.kioqs.dto;
// class de url de  calback
public class GetPayResponse {
	private  String tx_reference ;// reference genérer par paygate
	private String identifier ; // code de la transaction genérer par telal
	private String payment_reference;  // code generer par l'operateur
	private String amount ;
	private  String datetime ;
	private String payment_method ;// FLOOZ
	private String phone_number ;
	public GetPayResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetPayResponse(String tx_reference, String identifier, String payment_reference, String amount,
			String datetime, String payment_method, String phone_number) {
		super();
		this.tx_reference = tx_reference;
		this.identifier = identifier;
		this.payment_reference = payment_reference;
		this.amount = amount;
		this.datetime = datetime;
		this.payment_method = payment_method;
		this.phone_number = phone_number;
	}
	public String getTx_reference() {
		return tx_reference;
	}
	public void setTx_reference(String tx_reference) {
		this.tx_reference = tx_reference;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPayment_reference() {
		return payment_reference;
	}
	public void setPayment_reference(String payment_reference) {
		this.payment_reference = payment_reference;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "GetPayResponse [tx_reference=" + tx_reference + ", identifier=" + identifier + ", payment_reference="
				+ payment_reference + ", amount=" + amount + ", datetime=" + datetime + ", payment_method="
				+ payment_method + ", phone_number=" + phone_number + "]";
	}
	
	
	 
	 
}
