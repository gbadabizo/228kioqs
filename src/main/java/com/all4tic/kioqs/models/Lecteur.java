package com.all4tic.kioqs.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
@Entity
public class Lecteur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idlecteur;
	@NotBlank
	@Size(max=100)
	private String nom ;
	@NotBlank
	@Size(max=150)
	private String prenoms;
	@NotNull
	@Column(unique=true)
	@Size(max=12)
	private String code ;
	@NotNull
	@Column(unique=true)
	@Size(max=20)
	private String telephone;
	private int status=1;
	private int isvalidated = 0 ;
	public Lecteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecteur(long idlecteur, @NotBlank @Size(max = 100) String nom, @NotBlank @Size(max = 150) String prenoms,
			String code, @Size(max = 20) String telephone, int status, int isvalidated) {
		super();
		this.idlecteur = idlecteur;
		this.nom = nom;
		this.prenoms = prenoms;
		this.code = code;
		this.telephone = telephone;
		this.status = status;
		this.isvalidated = isvalidated;
	}
	public long getIdlecteur() {
		return idlecteur;
	}
	public void setIdlecteur(long idlecteur) {
		this.idlecteur = idlecteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsvalidated() {
		return isvalidated;
	}
	public void setIsvalidated(int isvalidated) {
		this.isvalidated = isvalidated;
	}
	

}
