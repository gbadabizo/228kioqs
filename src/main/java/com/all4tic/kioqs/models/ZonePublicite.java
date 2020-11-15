package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ZonePublicite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idzonepublicite ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idzone")
	private Zone zone;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idpublicite")
	private Publicite publicite ;
	private LocalDate datedebut;
	private LocalDate datefin ;
	private int actifstatus=0;
	private int status=1 ;
	
	public ZonePublicite(long idzonepublicite, Zone zone, Publicite publicite, LocalDate datedebut, LocalDate datefin,
			int actifstatus, int status) {
		super();
		this.idzonepublicite = idzonepublicite;
		this.zone = zone;
		this.publicite = publicite;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.actifstatus = actifstatus;
		this.status = status;
	}
	public ZonePublicite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getActifstatus() {
		return actifstatus;
	}
	public void setActifstatus(int actifstatus) {
		this.actifstatus = actifstatus;
	}
	public long getIdzonepublicite() {
		return idzonepublicite;
	}
	public void setIdzonepublicite(long idzonepublicite) {
		this.idzonepublicite = idzonepublicite;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Publicite getPublicite() {
		return publicite;
	}
	public void setPublicite(Publicite publicite) {
		this.publicite = publicite;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ZonePublicite [idzonepublicite=" + idzonepublicite + ", zone=" + zone + ", publicite=" + publicite
				+ ", datedebut=" + datedebut + ", datefin=" + datefin + ", actifstatus=" + actifstatus + ", status="
				+ status + "]";
	}
	
}
