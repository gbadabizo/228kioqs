package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.all4tic.kioqs.models.JobCategorie;

public interface JobCategorieDao extends CrudRepository<JobCategorie, Integer> {
	List<JobCategorie> findAllByStatus(int status); 

}
