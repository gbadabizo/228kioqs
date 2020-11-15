package com.all4tic.kioqs.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity 
@Immutable 
public class vpublicitezone {
	@Id
	private long idzonepublicite ;
	private long idpublicite ;
	private String urlpublicite;
	private String pubimgurl;
	private String pubdesc;
	private String zonedesc ;
	private String zonelibelle;
	private String zonecode ;
	private int actifstatus;
	private LocalDate datedebut;
	private LocalDate datefin;
	public vpublicitezone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vpublicitezone(long idzonepublicite, long idpublicite, String urlpublicite, String pubimgurl, String pubdesc,
			String zonedesc, String zonelibelle, String zonecode, int actifstatus, LocalDate datedebut,
			LocalDate datefin) {
		super();
		this.idzonepublicite = idzonepublicite;
		this.idpublicite = idpublicite;
		this.urlpublicite = urlpublicite;
		this.pubimgurl = pubimgurl;
		this.pubdesc = pubdesc;
		this.zonedesc = zonedesc;
		this.zonelibelle = zonelibelle;
		this.zonecode = zonecode;
		this.actifstatus = actifstatus;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}

	public long getIdpublicite() {
		return idpublicite;
	}
	public void setIdpublicite(long idpublicite) {
		this.idpublicite = idpublicite;
	}
	
	public long getIdzonepublicite() {
		return idzonepublicite;
	}
	public void setIdzonepublicite(long idzonepublicite) {
		this.idzonepublicite = idzonepublicite;
	}
	public String getUrlpublicite() {
		return urlpublicite;
	}
	public void setUrlpublicite(String urlpublicite) {
		this.urlpublicite = urlpublicite;
	}
	public String getPubimgurl() {
		return pubimgurl;
	}
	public void setPubimgurl(String pubimgurl) {
		this.pubimgurl = pubimgurl;
	}
	public String getPubdesc() {
		return pubdesc;
	}
	public void setPubdesc(String pubdesc) {
		this.pubdesc = pubdesc;
	}
	public String getZonedesc() {
		return zonedesc;
	}
	public void setZonedesc(String zonedesc) {
		this.zonedesc = zonedesc;
	}
	public String getZonelibelle() {
		return zonelibelle;
	}
	public void setZonelibelle(String zonelibelle) {
		this.zonelibelle = zonelibelle;
	}
	public String getZonecode() {
		return zonecode;
	}
	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}
	public int getActifstatus() {
		return actifstatus;
	}
	public void setActifstatus(int actifstatus) {
		this.actifstatus = actifstatus;
	}
	public LocalDate getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}
	public LocalDate getDatefin() {
		return datefin;
	}
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
	
	

}
