package com.all4tic.kioqs.dto;

import java.time.LocalDate;

public class JobsDto {
	private long idjobs ;
	private String titre ;
	private String description ;
	private String profil;
	private String typecontrat; 
	private String pays;
	private String source;
	private String adrjob ;
	private String urlImage ;// 
	private LocalDate dateannonce;
	private LocalDate datecloture;
	private String urlFichier ;
	private int validated;
	private int status;
	private int categorie;
	private String libcategorie ;
	
	public JobsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobsDto(long idjobs, String titre, String description, String profil, String typecontrat, String pays,
			String adrjob, String urlImage, LocalDate dateannonce, LocalDate datecloture, String urlFichier,
			int validated, int status, int categorie, String libcategorie) {
		super();
		this.idjobs = idjobs;
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
		this.categorie = categorie;
		this.libcategorie = libcategorie;
	}
	
	public JobsDto(long idjobs, String titre, String description, String profil, String typecontrat, String pays,
			String source, String adrjob, String urlImage, LocalDate dateannonce, LocalDate datecloture,
			String urlFichier, int validated, int status, int categorie, String libcategorie) {
		super();
		this.idjobs = idjobs;
		this.titre = titre;
		this.description = description;
		this.profil = profil;
		this.typecontrat = typecontrat;
		this.pays = pays;
		this.source = source;
		this.adrjob = adrjob;
		this.urlImage = urlImage;
		this.dateannonce = dateannonce;
		this.datecloture = datecloture;
		this.urlFichier = urlFichier;
		this.validated = validated;
		this.status = status;
		this.categorie = categorie;
		this.libcategorie = libcategorie;
	}
	public long getIdjobs() {
		return idjobs;
	}
	public void setIdjobs(long idjobs) {
		this.idjobs = idjobs;
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
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
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
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDatecloture(LocalDate datecloture) {
		this.datecloture = datecloture;
	}
	public String getUrlFichier() {
		return urlFichier;
	}
	public void setUrlFichier(String urlFichier) {
		this.urlFichier = urlFichier;
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
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public String getLibcategorie() {
		return libcategorie;
	}
	public void setLibcategorie(String libcategorie) {
		this.libcategorie = libcategorie;
	}
	
}
