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
import org.hibernate.annotations.Type;

import com.sun.istack.NotNull;


@Entity
public class Jobs   implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idjobs ;
	@NotNull
	private String code ;
	@Type(type="text")
	@NotNull
	private String titre ;
	@Type(type="text")
	@NotNull
	private String description ;
	@NotNull
	@Type(type="text")
	private String profil;
	@Type(type="text")
	private String typecontrat; // cdd , CDDI etc
	private String pays;
	@Type(type="text")
	private String adrjob ;// adresse ou il faut envoyé les dossiers;
	 @NotNull
	 @Column(unique=true)
	private String urlImage ;// image de garde
	private LocalDate dateannonce;
	private LocalDate datecloture;
	private String urlFichier ;
	private int validated=0;
	private int status=1;
	private LocalDate datecreated;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idjobcategorie")
	private JobCategorie jobCategorie;
	private String source ;
	
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Jobs(long idjobs, String code, String titre, String description, String profil, String typecontrat,
			String pays, String adrjob, String urlImage, LocalDate dateannonce, LocalDate datecloture,
			String urlFichier, int validated, int status, LocalDate datecreated, JobCategorie jobCategorie,
			String source) {
		super();
		this.idjobs = idjobs;
		this.code = code;
		this.titre = titre;
		this.description = description;
		this.profil = profil;
		this.typecontrat = typecontrat;
		this.pays = pays;
		this.adrjob = adrjob;
		this.urlImage = urlImage;
		this.dateannonce = dateannonce;
		this.datecloture = datecloture;
		this.urlFichier = urlFichier;
		this.validated = validated;
		this.status = status;
		this.datecreated = datecreated;
		this.jobCategorie = jobCategorie;
		this.source = source;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getUrlFichier() {
		return urlFichier;
	}
	public void setUrlFichier(String urlFichier) {
		this.urlFichier = urlFichier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setIdjobs(long idjobs) {
		this.idjobs = idjobs;
	}
	public long getIdjobs() {
		return idjobs;
	}
	public void setId_jobs(long id_jobs) {
		this.idjobs = id_jobs;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getTypecontrat() {
		return typecontrat;
	}
	public void setTypecontrat(String typecontrat) {
		this.typecontrat = typecontrat;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getAdrjob() {
		return adrjob;
	}
	public void setAdrjob(String adrjob) {
		this.adrjob = adrjob;
	}
	public LocalDate getDateannonce() {
		return dateannonce;
	}
	public void setDateannonce(LocalDate dateannonce) {
		this.dateannonce = dateannonce;
	}
	public LocalDate getDatecloture() {
		return datecloture;
	}
	public void setDatecloture(LocalDate datecloture) {
		this.datecloture = datecloture;
	}
	public int getValidated() {
		return validated;
	}
	public void setValidated(int validated) {
		this.validated = validated;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDate getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(LocalDate datecreated) {
		this.datecreated = datecreated;
	}
	
	public JobCategorie getJobCategorie() {
		return jobCategorie;
	}


	public void setJobCategorie(JobCategorie jobCategorie) {
		this.jobCategorie = jobCategorie;
	}


	@Override
	public String toString() {
		return "Jobs [idjobs=" + idjobs + ", code=" + code + ", titre=" + titre + ", description=" + description
				+ ", profil=" + profil + ", typecontrat=" + typecontrat + ", pays=" + pays + ", adrjob=" + adrjob
				+ ", urlImage=" + urlImage + ", dateannonce=" + dateannonce + ", datecloture=" + datecloture
				+ ", urlFichier=" + urlFichier + ", validated=" + validated + ", status=" + status + ", datecreated="
				+ datecreated + ", jobCategorie=" + jobCategorie + ", source=" + source + "]";
	}

	
	
	
	
}
