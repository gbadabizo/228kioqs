package com.all4tic.kioqs.dto;

import java.time.LocalDate;

public class CheckResponseDto {
	private  String tx_reference ;
	private String  payment_reference;
	private int status ;
	private String payment_method;
	private LocalDate datetime;
	public CheckResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckResponseDto(String tx_reference, String payment_reference, int status, String payment_method,
			LocalDate datetime) {
		super();
		this.tx_reference = tx_reference;
		this.payment_reference = payment_reference;
		this.status = status;
		this.payment_method = payment_method;
		this.datetime = datetime;
	}
	public String getTx_reference() {
		return tx_reference;
	}
	public void setTx_reference(String tx_reference) {
		this.tx_reference = tx_reference;
	}
	public String getPayment_reference() {
		return payment_reference;
	}
	public void setPayment_reference(String payment_reference) {
		this.payment_reference = payment_reference;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public LocalDate getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}
	

}
