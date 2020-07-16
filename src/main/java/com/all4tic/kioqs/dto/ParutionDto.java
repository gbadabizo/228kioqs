package com.all4tic.kioqs.dto;

import java.time.LocalDate;

public class ParutionDto {
	 	 private  long idparution ;
		 private String code ;
		 private LocalDate dateParution ;
		 private String numParution;
		 private String urlImage ;// image de garde
		 private String  premierTitre ;
		 private String descPremierTitre ;
		 private String  secondTitre ;
		 private String descSecondTitre ;
		 private String urlFichier ; // fichier pdf du revue
		 private int validated = 0;
		 private int published = 0;
		 private int status=1;
		 private int idagence;
		 private String libelleAgence;
		 private double prixUnit ;
		public ParutionDto(long idparution, String code, LocalDate date, String numParution, String urlImage,
				String premierTitre, String descPremierTitre, String secondTitre, String descsecondTitre,
				String urlFichier, int validated, int published, int status, int idagence) {
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
			this.idagence = idagence;
		}
		
		public ParutionDto(long idparution, String code, LocalDate dateParution, String numParution, String urlImage,
				String premierTitre, String descPremierTitre, String secondTitre, String descSecondTitre,
				String urlFichier, int validated, int published, int status, int idagence, String libelleAgence,
				double prixUinit) {
			super();
			this.idparution = idparution;
			this.code = code;
			this.dateParution = dateParution;
			this.numParution = numParution;
			this.urlImage = urlImage;
			this.premierTitre = premierTitre;
			this.descPremierTitre = descPremierTitre;
			this.secondTitre = secondTitre;
			this.descSecondTitre = descSecondTitre;
			this.urlFichier = urlFichier;
			this.validated = validated;
			this.published = published;
			this.status = status;
			this.idagence = idagence;
			this.libelleAgence = libelleAgence;
			this.prixUnit = prixUinit;
		}
		
		public double getPrixUnit() {
			return prixUnit;
		}

		public void setPrixUnit(double prixUinit) {
			this.prixUnit = prixUinit;
		}

		public ParutionDto() {
			super();
			// TODO Auto-generated constructor stub
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
		public int getIdagence() {
			return idagence;
		}
		public void setIdagence(int idagence) {
			this.idagence = idagence;
		}
		public String getLibelleAgence() {
			return libelleAgence;
		}
		public void setLibelleAgence(String libelleAgence) {
			this.libelleAgence = libelleAgence;
		}
		
		 
}
