package com.all4tic.kioqs.dto;

import java.time.LocalDate;

public class RequestParution {
	private String code ;
	 private LocalDate dateParution ;
	 private long numParution;
	 private String urlImage ;// image de garde
	 private String  premierTitre ;
	 private String descPremierTitre ;
	 private String  secondTitre ;
	 private String descSecondTitre ;
	public RequestParution(String code, LocalDate dateParution, long numParution, String urlImage, String premierTitre,
			String descPremierTitre, String secondTitre, String descSecondTitre) {
		super();
		this.code = code;
		this.dateParution = dateParution;
		this.numParution = numParution;
		this.urlImage = urlImage;
		this.premierTitre = premierTitre;
		this.descPremierTitre = descPremierTitre;
		this.secondTitre = secondTitre;
		this.descSecondTitre = descSecondTitre;
	}
	public RequestParution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDate getDateParution() {
		return dateParution;
	}
	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}
	public long getNumParution() {
		return numParution;
	}
	public void setNumParution(long numParution) {
		this.numParution = numParution;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getPremierTitre() {
		return premierTitre;
	}
	public void setPremierTitre(String premierTitre) {
		this.premierTitre = premierTitre;
	}
	public String getDescPremierTitre() {
		return descPremierTitre;
	}
	public void setDescPremierTitre(String descPremierTitre) {
		this.descPremierTitre = descPremierTitre;
	}
	public String getSecondTitre() {
		return secondTitre;
	}
	public void setSecondTitre(String secondTitre) {
		this.secondTitre = secondTitre;
	}
	public String getDescSecondTitre() {
		return descSecondTitre;
	}
	public void setDescSecondTitre(String descSecondTitre) {
		this.descSecondTitre = descSecondTitre;
	}
	@Override
	public String toString() {
		return "RequestParution [code=" + code + ", dateParution=" + dateParution + ", numParution=" + numParution
				+ ", urlImage=" + urlImage + ", premierTitre=" + premierTitre + ", descPremierTitre=" + descPremierTitre
				+ ", secondTitre=" + secondTitre + ", descSecondTitre=" + descSecondTitre + "]";
	}
	 
}
