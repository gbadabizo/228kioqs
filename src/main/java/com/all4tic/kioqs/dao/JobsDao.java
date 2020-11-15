package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.JobCategorie;
import com.all4tic.kioqs.models.Jobs;


@Repository
public interface JobsDao extends CrudRepository<Jobs, Long> {
	List<Jobs> findAllByStatus(int status);
	//Slice<Jobs>findAllByStatus(int status, Pageable pageable);
	Page<Jobs>findAllByStatus(int status, Pageable pageable);
	List<Jobs> findTop10ByStatusAndJobCategorieOrderByDateclotureDesc(int status, JobCategorie categ);
}
