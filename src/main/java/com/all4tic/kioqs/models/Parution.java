package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
@Entity
public class Parution implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private  long idparution ;
	@NotNull
	@Column(unique=true)
	 private String code ;
	 @NotNull
	 private LocalDate dateParution ;
	 @NotNull
	 private String numParution;
	 @NotNull
	 @Column(unique=true)
	 private String urlImage ;// image de garde
	 @Size(max=200)
	 private String  premierTitre ;
	
	 private String descPremierTitre ;
	 @Size(max=200)
	 private String  secondTitre ;
	
	 private String descSecondTitre ;
	 private String urlFichier ; // fichier pdf du revue
	 private int validated = 0;
	 private int published = 0;
	 private int status=1;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="idagence")
	 private Agence agence;
	public Parution() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Parution(long idparution, String code, LocalDate date, String numParution, String urlImage,
			@Size(max = 200) String premierTitre, @Size(max = 250) String descPremierTitre,
			@Size(max = 200) String secondTitre, @Size(max = 250) String descsecondTitre, String urlFichier,
			int validated, int published, int status, Agence agence) {
		super();
		this.idparution = idparution;
		this.code = code;
		this.dateParution = date;
		this.numParution = numParution;
		this.urlImage = urlImage;
		this.premierTitre = premierTitre;
		this.descPremierTitre = descPremierTitre;
		this.secondTitre = secondTitre;
		this.descSecondTitre = descsecondTitre;
		this.urlFichier = urlFichier;
		this.validated = validated;
		this.published = published;
		this.status = status;
		this.agence = agence;
	}
	

	public int getValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getIdparution() {
		return idparution;
	}
	public void setIdparution(long idparution) {
		this.idparution = idparution;
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

	
	public String getNumParution() {
		return numParution;
	}

	public void setNumParution(String numParution) {
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

	public String getUrlFichier() {
		return urlFichier;
	}
	public void setUrlFichier(String urlFichier) {
		this.urlFichier = urlFichier;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Parution [idparution=" + idparution + ", code=" + code + ", date=" + dateParution + ", numParution="
				+ numParution + ", urlImage=" + urlImage + ", premierTitre=" + premierTitre + ", descPremierTitre="
				+ descPremierTitre + ", secondTitre=" + secondTitre + ", descsecondTitre=" + descSecondTitre
				+ ", urlFichier=" + urlFichier + ", validated=" + validated + ", published=" + published + ", status="
				+ status + ", agence=" + agence + "]";
	}
	 

}
