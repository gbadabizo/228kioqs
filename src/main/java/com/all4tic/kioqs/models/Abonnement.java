package com.all4tic.kioqs.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Abonnement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idabon;
	private String libelle;
	private int duree ;
	private int status=1;
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Abonnement(int idabon, String libelle, int duree, int status) {
		super();
		this.idabon = idabon;
		this.libelle = libelle;
		this.duree = duree;
		this.status = status;
	}
	public int getIdabon() {
		return idabon;
	}
	public void setIdabon(int idabon) {
		this.idabon = idabon;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Abonnement [idabon=" + idabon + ", libelle=" + libelle + ", duree=" + duree + ", status=" + status
				+ "]";
	}


}
