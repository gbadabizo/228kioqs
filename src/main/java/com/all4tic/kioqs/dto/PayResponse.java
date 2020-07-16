package com.all4tic.kioqs.dto;

public class PayResponse {
	String tx_reference ;
	int status ;
	/*
	 *  Les valeurs possible de la transaction sont:
		0 : Transaction enregistrée avec succès
		2 : Jeton d’authentification invalide
		4 : Paramètres Invalides
		6 : Doublons détectées. Une transaction avec le même identifiant existe déja.
	 */
	
	public PayResponse(String tx_reference, int status) {
		super();
		this.tx_reference = tx_reference;
		this.status = status;
	}
	public PayResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTx_reference() {
		return tx_reference;
	}
	public void setTx_reference(String tx_reference) {
		this.tx_reference = tx_reference;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PayResponse [tx_reference=" + tx_reference + ", status=" + status + "]";
	}
	
}
