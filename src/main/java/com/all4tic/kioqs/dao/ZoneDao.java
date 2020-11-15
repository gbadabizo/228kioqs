package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Zone;
@Repository
public interface ZoneDao extends CrudRepository<Zone,Integer> {
 List<Zone>findAllByStatus(int status);
}
