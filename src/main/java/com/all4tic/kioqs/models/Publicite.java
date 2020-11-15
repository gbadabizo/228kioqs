package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
@Entity
public class Publicite implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpublicite ;
	private String urlpublicite;
	private String imageurl ;
	@NotNull
	private String code ;
	private String description ;
	private int status=1 ;
	@OneToMany(mappedBy="publicite")
	List<ZonePublicite> zonepubs ;
	
	public Publicite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Publicite(long idpublicite, String urlpublicite, String imageurl, String description) {
		super();
		this.idpublicite = idpublicite;
		this.urlpublicite = urlpublicite;
		this.imageurl = imageurl;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getIdpublicite() {
		return idpublicite;
	}
	public void setIdpublicite(long idpublicite) {
		this.idpublicite = idpublicite;
	}
	@JsonIgnore
	public List<ZonePublicite> getZonepubs() {
		return zonepubs;
	}
	@JsonIgnore
	public void setZonepubs(List<ZonePublicite> zonepubs) {
		this.zonepubs = zonepubs;
	}
	public String getUrlpublicite() {
		return urlpublicite;
	}
	public void setUrlpublicite(String urlpublicite) {
		this.urlpublicite = urlpublicite;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
