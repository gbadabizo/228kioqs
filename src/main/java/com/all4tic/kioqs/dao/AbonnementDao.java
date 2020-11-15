package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Abonnement;
@Repository
public interface AbonnementDao extends CrudRepository<Abonnement, Integer> {
 List<Abonnement> findAll();
}
