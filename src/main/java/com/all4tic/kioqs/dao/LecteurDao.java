package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Lecteur;

@Repository
public interface LecteurDao  extends CrudRepository<Lecteur, Long>{
	Lecteur findByCode(String code);
	Lecteur findByTelephone(String telephone);
	List<Lecteur> findByStatus(int status);
	Slice<Lecteur>findAllByStatus(int status, Pageable pageable);
}
