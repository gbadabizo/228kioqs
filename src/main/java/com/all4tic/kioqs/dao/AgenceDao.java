package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.Categorie;
@Repository
public interface AgenceDao extends CrudRepository<Agence, Integer> {
		List<Agence>findAllByStatus(int status);
		List<Agence> findAllByStatusAndCategorie(int status , Categorie c);
}
