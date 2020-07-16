package com.all4tic.kioqs.dao;


import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Activation;
import com.all4tic.kioqs.models.Lecteur;



public interface ActivationDao extends CrudRepository<Activation, Integer> {
    public Activation findActivationByLecteurAndCode(Lecteur lecteur, String code);
}
