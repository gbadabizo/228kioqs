package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class JobCategorie   implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcategorie ;
	@Size(max=8)
	@Column(unique=true)
	private String code;
	private String  libelle; 
	private String description;
	private int status=1;
	@OneToMany(mappedBy="jobCategorie")
	private Set<Jobs> jobs ;
	private LocalDate createAt = LocalDate.now();
	//private  int createdBy = 
	public JobCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JobCategorie(int idcategorie, @Size(max = 5) String code, String libelle, String description, int status) {
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
	public Set<Jobs> getJobs() {
		return jobs;
	}
	@JsonIgnore
	public void setJobs(Set<Jobs> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Categorie [idcategorie=" + idcategorie + ", libelle=" + libelle + ", description=" + description
				+ ", status=" + status + "]";
	}
	

}
