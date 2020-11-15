package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.sun.istack.NotNull;
@Entity
public class News implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idnews ;
	@NotNull
	@Column(unique=true)
	 private String code ;
	 @NotNull
	 private LocalDate datePublication ;
	 private String urlSource;
	 private String urlvideo;
	 private String urlImage1;
	 private String urlImage2;
	 private String urlImage3;
	 private String urlImage4;
	 @NotNull
	 @Column(unique=true)
	 private String urlImage ;// image de garde
	 @Size(max=200)
	 private String  titre ;
	 @Type(type="text")
	 private String contenu ;
	 private String source ;
	 private String urlFichier ; // fichier pdf du revue
	 private int validated = 0;
	 private int published = 0;
	 private int status=1;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(long idnews, String code, LocalDate datePublication, String urlSource, String urlvideo,
			String urlImage1, String urlImage2, String urlImage3, String urlImage4, String urlImage,
			@Size(max = 200) String titre, String contenu, String urlFichier, int validated, int published,
			int status) {
		super();
		this.idnews = idnews;
		this.code = code;
		this.datePublication = datePublication;
		this.urlSource = urlSource;
		this.urlvideo = urlvideo;
		this.urlImage1 = urlImage1;
		this.urlImage2 = urlImage2;
		this.urlImage3 = urlImage3;
		this.urlImage4 = urlImage4;
		this.urlImage = urlImage;
		this.titre = titre;
		this.contenu = contenu;
		this.urlFichier = urlFichier;
		this.validated = validated;
		this.published = published;
		this.status = status;
	}
	public long getIdnews() {
		return idnews;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setIdnews(long idnews) {
		this.idnews = idnews;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDate getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}
	public String getUrlSource() {
		return urlSource;
	}
	public void setUrlSource(String urlSource) {
		this.urlSource = urlSource;
	}
	public String getUrlvideo() {
		return urlvideo;
	}
	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}
	public String getUrlImage1() {
		return urlImage1;
	}
	public void setUrlImage1(String urlImage1) {
		this.urlImage1 = urlImage1;
	}
	public String getUrlImage2() {
		return urlImage2;
	}
	public void setUrlImage2(String urlImage2) {
		this.urlImage2 = urlImage2;
	}
	public String getUrlImage3() {
		return urlImage3;
	}
	public void setUrlImage3(String urlImage3) {
		this.urlImage3 = urlImage3;
	}
	public String getUrlImage4() {
		return urlImage4;
	}
	public void setUrlImage4(String urlImage4) {
		this.urlImage4 = urlImage4;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
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
	 
}
