package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.all4tic.kioqs.utilities.Utility;
@Entity
public class Agence  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idagence ;
	@NotBlank
	@Size(max=200)
	private String nom ;
	@Size(max = 4)
	@NotNull
	@Column(unique = true)
    private 	String code= ""+Utility.generateRandomDigits(4) ;
	@Size(max=254)
	private String description;
	@Size(max=250)
	@NotBlank
	private String adresse ;
	@NotBlank
	private String periodicite;
	@NotBlank
	@Column(unique = true)
	private String email ;
	@NotBlank
	@Size(max=8)
	private String telephone1;
	@Size(max=8)
	private String telephone2;
	@Size(max=8)
	private String numFlooz ;
	@Size(max=8)
	private String numTmoney;
	@PositiveOrZero
	private double prixUnit ;
	private int status=1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcategorie")
	private Categorie categorie;
	@OneToMany(mappedBy="agence")
	private Set<Parution> parutions ;
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agence(int idagence, @NotBlank @Size(max = 200) String nom, @Size(max = 4) @NotNull String code,
			@Size(max = 254) String description, @Size(max = 250) @NotBlank String adresse, @NotBlank String email,
			@NotBlank @Size(max = 8) String telephone1, @Size(max = 8) String telephone2,
			@Size(max = 8) String numFlooz, @Size(max = 8) String numTmoney, @PositiveOrZero double prixUnit,
			int status, Categorie categorie) {
		super();
		this.idagence = idagence;
		this.nom = nom;
		this.code = code;
		this.description = description;
		this.adresse = adresse;
		this.email = email;
		this.telephone1 = telephone1;
		this.telephone2 = telephone2;
		this.numFlooz = numFlooz;
		this.numTmoney = numTmoney;
		this.prixUnit = prixUnit;
		this.status = status;
		this.categorie = categorie;
	}

	
	public double getPrixUnit() {
		return prixUnit;
	}


	public void setPrixUnit(double prixUnit) {
		this.prixUnit = prixUnit;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getIdagence() {
		return idagence;
	}
	public void setIdagence(int idAgence) {
		this.idagence = idAgence;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getNumFlooz() {
		return numFlooz;
	}
	public void setNumFlooz(String numflooz) {
		this.numFlooz = numflooz;
	}
	public String getNumTmoney() {
		return numTmoney;
	}
	public void setNumTmoney(String numTmoney) {
		this.numTmoney = numTmoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Agence [idagence=" + idagence + ", nom=" + nom + ", description=" + description + ", adresse=" + adresse
				+ ", email=" + email + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", numflooz="
				+ numFlooz + ", numTmoney=" + numTmoney + ", status=" + status + "]";
	}

	public Set<Parution> getParutions() {
		return parutions;
	}

	public void setParutions(Set<Parution> parutions) {
		this.parutions = parutions;
	}

	public String getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}
	
	
	
	

}
