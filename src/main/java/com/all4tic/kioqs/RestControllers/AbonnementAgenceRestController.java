package com.all4tic.kioqs.RestControllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.kioqs.dao.AbonnementDao;
import com.all4tic.kioqs.dao.AgenceAbonnementDao;
import com.all4tic.kioqs.dao.AgenceDao;
import com.all4tic.kioqs.dto.AgenceAbonnementRequest;
import com.all4tic.kioqs.models.Abonnement;
import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.AgenceAbonnement;


@RestController
@RequestMapping("/api/abonnement/")
@CrossOrigin(origins = "*")
public class AbonnementAgenceRestController {

	@Autowired
	private AbonnementDao abonnementDao ;
	@Autowired
	private AgenceDao agenceDao ;
	@Autowired 
	private AgenceAbonnementDao agenceAbonnementDao ;
	
	@GetMapping("all")
	public ResponseEntity<List<Abonnement>> getAllAbonnementype(){
		
		return new ResponseEntity<>(abonnementDao.findAll(), HttpStatus.OK);
	}
	/*
	 * on recupère la liste des types abonnement avec le montant  par agence
	 */
	@GetMapping("agence/{id}")
	public ResponseEntity<List<AgenceAbonnement>>getAllAbonnementsByAgence(@PathVariable("id") int id){
		Optional<Agence> agenceOpt = agenceDao.findById(id);
		if(agenceOpt.isPresent()) {
			Agence agence = agenceOpt.get();
			List<AgenceAbonnement> agenceAbns = agenceAbonnementDao.findAllByAgenceAndStatus(agence, 1);
			return new ResponseEntity<>(agenceAbns, HttpStatus.OK);
		}
		return null ;
	}
	@PostMapping("add")
	public ResponseEntity<AgenceAbonnement> addAbonnementAgence(@RequestBody AgenceAbonnementRequest  agenceAbonnementRequest){
		if(agenceAbonnementRequest !=null) {
			Agence agence =agenceDao.findById(agenceAbonnementRequest.getIdagence()).get() ;
			Abonnement abon = abonnementDao.findById(agenceAbonnementRequest.getIdabonnement()).get();
			AgenceAbonnement agenceAbonnement =  agenceAbonnementDao.findByAgenceAndAbonnementAndStatus(agence, abon, 1);
			if(agenceAbonnement == null)
			     agenceAbonnement = new AgenceAbonnement();
			 agenceAbonnement.setAgence(agence);
			 agenceAbonnement.setAbonnement(abon);
			 agenceAbonnement.setCode(agenceAbonnementRequest.getCode());
			 agenceAbonnement.setMontant(agenceAbonnementRequest.getMontant());
			 agenceAbonnement.setMontantext(agenceAbonnementRequest.getMontantext());
			 AgenceAbonnement newAgenceAbonnement = agenceAbonnementDao.save(agenceAbonnement);
			
			 return new ResponseEntity<>(newAgenceAbonnement, HttpStatus.OK);
			
		}
		return null ;
	}
	@GetMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteAbonnementAgenceById(@PathVariable int id ){
		AgenceAbonnement agb = agenceAbonnementDao.findById(id).get();
		if(agb !=null) {
			agb.setStatus(0);
			AgenceAbonnement agbdel = agenceAbonnementDao.save(agb);
			if(agbdel!=null)
				 return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return null ;
	}
}
