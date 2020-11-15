package com.all4tic.kioqs.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Zone implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idzone ;
	private String code ;
	private String libelle ;
	private String description;
	private int status=1 ;
	@OneToMany(mappedBy="zone")
	List<ZonePublicite> zonepubs ;
	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Zone(int idzone, String code, String libelle, String description, int status) {
		super();
		this.idzone = idzone;
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.status = status;
	}
	
	public int getIdzone() {
		return idzone;
	}

	public void setIdzone(int idzone) {
		this.idzone = idzone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@JsonIgnore
	public List<ZonePublicite> getZonepubs() {
		return zonepubs;
	}

	public void setZonepubs(List<ZonePublicite> zonepubs) {
		this.zonepubs = zonepubs;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
}
