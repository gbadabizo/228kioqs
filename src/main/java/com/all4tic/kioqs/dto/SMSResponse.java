package com.all4tic.kioqs.dto;

public class SMSResponse {
	private int ErrorCode ;
	private String ErrorDescription ;
	public String Data ;
	public SMSResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SMSResponse(int errorCode, String errorDescription) {
		super();
		ErrorCode = errorCode;
		ErrorDescription = errorDescription;
	}
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorDescription() {
		return ErrorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		ErrorDescription = errorDescription;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "SMSResponse [ErrorCode=" + ErrorCode + ", ErrorDescription=" + ErrorDescription + ", Data=" + Data
				+ "]";
	}
	
	
}

