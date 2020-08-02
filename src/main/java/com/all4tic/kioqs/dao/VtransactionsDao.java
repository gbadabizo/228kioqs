package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.vtransactions;
@Repository
public interface VtransactionsDao extends CrudRepository<vtransactions, Long> {
	Page<vtransactions>findAll(Pageable pageable);
	List<vtransactions>findByOrderByDateopDesc(); 

}
