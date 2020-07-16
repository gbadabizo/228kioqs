package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.Parution;

public interface ParutionDao extends CrudRepository<Parution, Long> {
	List<Parution>findAllByAgenceAndStatus(Agence agence, int status);
	List<Parution>findAllByPublishedOrderByDateParutionDesc(int published);
	Slice<Parution>findAllByPublished(int published, Pageable pageable);
	Slice<Parution>findAllByAgenceAndStatus(Agence agence, int status, Pageable pageable);

}
