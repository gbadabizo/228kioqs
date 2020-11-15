package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Abonnement;
import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.AgenceAbonnement;

public interface AgenceAbonnementDao extends CrudRepository<AgenceAbonnement, Integer> {
	List<AgenceAbonnement> findAllByAgenceAndStatus(Agence agence, int status);
	AgenceAbonnement findByAgenceAndAbonnementAndStatus(Agence agence , Abonnement abn, int status);

}
