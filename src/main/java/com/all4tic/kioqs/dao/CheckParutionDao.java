package com.all4tic.kioqs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.CheckParution;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
@Repository
public interface CheckParutionDao extends CrudRepository<CheckParution, Long>{
	CheckParution findByParutionAndLecteur(Parution p , Lecteur l);
}
