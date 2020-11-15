package com.all4tic.kioqs.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Suscribe;
import com.all4tic.kioqs.models.SuscribeAgence;
@Repository
public interface SuscribeAgenceDao extends CrudRepository<SuscribeAgence, Long> {
	SuscribeAgence findByLastsuscribe(Suscribe lastscuscribe);
	SuscribeAgence findByLecteurAndAgenceAndStatus(Lecteur lecteur, Agence agence, int status);
	List<SuscribeAgence> findByLecteurAndStatusOrderByDatefinDesc(Lecteur lecteur, int status);
	@Query(value = "from SuscribeAgence t where agence =:ag and  :dateop BETWEEN t.datedeb AND  t.datefin")
	public List<SuscribeAgence> getAllBetweenDates(@Param("ag") Agence ag,@Param("dateop") LocalDate startDate);

}
