package com.all4tic.kioqs.dto;

public class SMSRequest {
	private String SenderId = "228KIOSQS";
	private boolean Is_Unicode=true ;
	private boolean Is_Flash = false;
	private String message;
	private String MobileNumbers;
	public SMSRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SMSRequest(String senderId, boolean is_Unicode, boolean is_Flash, String message, String mobileNumbers) {
		super();
		SenderId = senderId;
		Is_Unicode = is_Unicode;
		Is_Flash = is_Flash;
		this.message = message;
		MobileNumbers = mobileNumbers;
	}
	public String getSenderId() {
		return SenderId;
	}
	public void setSenderId(String senderId) {
		SenderId = senderId;
	}
	public boolean isIs_Unicode() {
		return Is_Unicode;
	}
	public void setIs_Unicode(boolean is_Unicode) {
		Is_Unicode = is_Unicode;
	}
	public boolean isIs_Flash() {
		return Is_Flash;
	}
	public void setIs_Flash(boolean is_Flash) {
		Is_Flash = is_Flash;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMobileNumbers() {
		return MobileNumbers;
	}
	public void setMobileNumbers(String mobileNumbers) {
		MobileNumbers = mobileNumbers;
	}
	@Override
	public String toString() {
		return "SMSRequest [SenderId=" + SenderId + ", Is_Unicode=" + Is_Unicode + ", Is_Flash=" + Is_Flash
				+ ", message=" + message + ", MobileNumbers=" + MobileNumbers + "]";
	}
	
}
