package com.all4tic.kioqs.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class vtransactions {
 @Id
 private long idtransaction;
 private String codetrans ;
 private String operateur;
 private String phone;
 private long idlecteur;
 private int status_pay;
 private long num_parution ;
 private String codelecteur;
 private String codeparution ;
 private String nomagence;
 private int idagence ;
 private LocalDate dateop ;
public vtransactions() {
	super();
	// TODO Auto-generated constructor stub
}
public vtransactions(long idtransaction, String codetrans, String operateur, String phone, long idlecteur,
		int status_pay, long num_parution, String codelecteur, String codeparution, String nomagence, int idagence,
		LocalDate dateop) {
	super();
	this.idtransaction = idtransaction;
	this.codetrans = codetrans;
	this.operateur = operateur;
	this.phone = phone;
	this.idlecteur = idlecteur;
	this.status_pay = status_pay;
	this.num_parution = num_parution;
	this.codelecteur = codelecteur;
	this.codeparution = codeparution;
	this.nomagence = nomagence;
	this.idagence = idagence;
	this.dateop = dateop;
}
public long getIdtransaction() {
	return idtransaction;
}
public void setIdtransaction(long idtransaction) {
	this.idtransaction = idtransaction;
}
public String getCodetrans() {
	return codetrans;
}
public void setCodetrans(String codetrans) {
	this.codetrans = codetrans;
}
public String getOperateur() {
	return operateur;
}
public void setOperateur(String operateur) {
	this.operateur = operateur;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public long getIdlecteur() {
	return idlecteur;
}
public void setIdlecteur(long idlecteur) {
	this.idlecteur = idlecteur;
}
public int getStatus_pay() {
	return status_pay;
}
public void setStatus_pay(int status_pay) {
	this.status_pay = status_pay;
}
public long getNum_parution() {
	return num_parution;
}
public void setNum_parution(long num_parution) {
	this.num_parution = num_parution;
}
public String getCodelecteur() {
	return codelecteur;
}
public void setCodelecteur(String codelecteur) {
	this.codelecteur = codelecteur;
}
public String getCodeparution() {
	return codeparution;
}
public void setCodeparution(String codeparution) {
	this.codeparution = codeparution;
}
public String getNomagence() {
	return nomagence;
}
public void setNomagence(String nomagence) {
	this.nomagence = nomagence;
}
public int getIdagence() {
	return idagence;
}
public void setIdagence(int idagence) {
	this.idagence = idagence;
}
public LocalDate getDateop() {
	return dateop;
}
public void setDateop(LocalDate dateop) {
	this.dateop = dateop;
}
 
 
}
