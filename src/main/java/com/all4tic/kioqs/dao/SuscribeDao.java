package com.all4tic.kioqs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Suscribe;
@Repository
public interface SuscribeDao extends CrudRepository<Suscribe, Integer> {
	

}
