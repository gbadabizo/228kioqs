package com.all4tic.kioqs.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.vpublicitezone;
@Repository
public interface VpublicitezoneDao  extends CrudRepository<vpublicitezone, Long>{
	Page<vpublicitezone>findAll(Pageable pageable);
	vpublicitezone findByZonecodeAndActifstatus(String zonecode, int actifstatus);

}
