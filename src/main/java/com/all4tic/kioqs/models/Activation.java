package com.all4tic.kioqs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Activation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id_activation ;
    private String code ;
    private long dateactivation =  new Date().getTime();
    private int status = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lecteur")
    private Lecteur lecteur ;

    public Activation() {
    }

    public Activation(String code, long dateactivation, int status, Lecteur lecteur) {
        this.code = code;
        this.dateactivation = dateactivation;
        this.status = status;
        this.lecteur = lecteur;
    }

    public int getId_activation() {
        return id_activation;
    }

    public void setId_activation(int id_activation) {
        this.id_activation = id_activation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getDateactivation() {
        return dateactivation;
    }

    public void setDateactivation(long dateactivation) {
        this.dateactivation = dateactivation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}

	@Override
	public String toString() {
		return "Activation [id_activation=" + id_activation + ", code=" + code + ", dateactivation=" + dateactivation
				+ ", status=" + status + ", lecteur=" + lecteur + "]";
	}

	
   

}
