package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcategorie ;
	@Size(max=8)
	private String code;
	private String  libelle; 
	private String description;
	private int status=1;
	@OneToMany(mappedBy="categorie")
	private Set<Agence> agences ;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(int idcategorie, @Size(max = 5) String code, String libelle, String description, int status) {
		super();
		this.idcategorie = idcategorie;
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.status = status;
	}

	public int getIdcategorie() {
		return idcategorie;
	}

	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonIgnore
	public Set<Agence> getAgences() {
		return agences;
	}
	@JsonIgnore
	public void setAgences(Set<Agence> agences) {
		this.agences = agences;
	}

	@Override
	public String toString() {
		return "Categorie [idcategorie=" + idcategorie + ", libelle=" + libelle + ", description=" + description
				+ ", status=" + status + "]";
	}
	
}
