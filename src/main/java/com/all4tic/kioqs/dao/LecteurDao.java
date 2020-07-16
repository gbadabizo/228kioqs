package com.all4tic.kioqs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Lecteur;
@Repository
public interface LecteurDao  extends CrudRepository<Lecteur, Long>{
	Lecteur findByCode(String code);
	Lecteur findByTelephone(String telephone);
}
