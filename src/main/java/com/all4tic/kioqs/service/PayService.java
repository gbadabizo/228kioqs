package com.all4tic.kioqs.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.dao.TransactionsDao;
import com.all4tic.kioqs.dao.TransactionsSuscribeDao;
import com.all4tic.kioqs.dto.CheckResponseDto;
import com.all4tic.kioqs.dto.PayResponse;
import com.all4tic.kioqs.dto.TransactionsDto;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Suscribe;
import com.all4tic.kioqs.models.Transactions;
import com.all4tic.kioqs.models.TransactionsSuscribe;
import com.all4tic.kioqs.utilities.PaySettings;
import com.all4tic.kioqs.utilities.Utility;

@Service
public class PayService {
	@Autowired 
	private ParutionDao  parutionDao;
	@Autowired
	private LecteurDao lecteurDao ;
	@Autowired
	private TransactionsDao transactionsDao;
	@Autowired
	private TransactionsSuscribeDao transactionsSuscribeDao;
	
	private final RestTemplate restTemplate;

	public PayService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	  }
	// envoyer un paiement via flooz
	public TransactionsDto sendPay(String numtel , long idparution , String codeLecteur) {
		
		Optional<Parution> parution = parutionDao.findById(idparution); // on recupère la parution	 
		if(parution.isPresent()){
			Parution p = parution.get();
			Lecteur l = lecteurDao.findByCode(codeLecteur); // on recupère le codelecteur
			Transactions tr = transactionsDao.findByParutionAndLecteurAndStatusPayAndStatus(p, l,1,1); // on verifier si il existe une transaction pour payer cette parution
			if(tr!=null) {
				tr.setStatus(0);
				transactionsDao.save(tr);
			}
			String codetrans= ""+Utility.generateRandomDigits(8);
			// create headers
			HttpHeaders headers = new HttpHeaders();
			//set content-type header
			headers.setContentType(MediaType.APPLICATION_JSON);
			//set accept header
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			//create a map for the params
			Map<String,Object> map = new HashMap<>();
			map.put("auth_token", PaySettings.PAYGATE_TOKEN);
			map.put("phone_number", numtel.trim());
			map.put("amount",5);// p.getAgence().getPrixUnit()
			map.put("description", p.getAgence().getNom()+" "+p.getCode());
			map.put("identifier", codetrans);
			Transactions tx = new Transactions();
			tx.setCodetrans(codetrans);
			tx.setLecteur(l);
			tx.setPhone(numtel);
			tx.setParution(p);
			tx.setOperateur("FLOOZ");
			Transactions txnew = transactionsDao.save(tx);
			if(txnew!=null) {
				//build request
				HttpEntity<Map<String, Object>>entity = new HttpEntity<>(map, headers);
				//send Post request 
				ResponseEntity<PayResponse> response =this.restTemplate.postForEntity(PaySettings.PAYGATE_URL1, entity, PayResponse.class);
			//check response status code 
				System.out.println(response.getBody().toString());
				if(response!=null) {
					Transactions txne= transactionsDao.findByCodetrans(codetrans);
					txne.setStatusPayAsk(response.getBody().getStatus());
					txne.setTxReference(response.getBody().getTx_reference());
				    Transactions txn = transactionsDao.save(txne);
				    
					return TransToTransDto(txn);
				}
			
			}
			
		}
		return null;
	}
	// envoyer un paiement abonnement via flooz
		public TransactionsDto sendPayAbonnement(String numtel ,Suscribe suscribe) {
			if(suscribe !=null) {
				TransactionsSuscribe tr = transactionsSuscribeDao.findByCodetransAndStatusPayAndStatus(suscribe.getCode(), 1, 1); // on verifier si il existe une transaction pour payer cet abonnement
				if(tr!=null) {
					tr.setStatus(0);
					transactionsSuscribeDao.save(tr);
				}
				String codetrans= ""+suscribe.getCode();
				// create headers
				HttpHeaders headers = new HttpHeaders();
				//set content-type header
				headers.setContentType(MediaType.APPLICATION_JSON);
				//set accept header
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				//create a map for the params
				Map<String,Object> map = new HashMap<>();
				map.put("auth_token", PaySettings.PAYGATE_TOKEN);
				map.put("phone_number", numtel.trim());
				map.put("amount",5); //suscribe.getAgenceabonnement().getMontant();
				map.put("description", "Abonnement - "+suscribe.getAgenceabonnement().getAgence().getNom());
				map.put("identifier", codetrans);
				TransactionsSuscribe tx = new TransactionsSuscribe();
				tx.setCodetrans(codetrans);
				tx.setPhone(numtel);
				tx.setSuscribe(suscribe);
				tx.setOperateur("FLOOZ");
				TransactionsSuscribe txnew = transactionsSuscribeDao.save(tx);
				if(txnew!=null) {
					//build request
					HttpEntity<Map<String, Object>>entity = new HttpEntity<>(map, headers);
					//send Post request 
					ResponseEntity<PayResponse> response =this.restTemplate.postForEntity(PaySettings.PAYGATE_URL1, entity, PayResponse.class);
				//check response status code 
					System.out.println(response.getBody().toString());
					if(response!=null) {
						TransactionsSuscribe txne= transactionsSuscribeDao.findByCodetrans(codetrans);
						txne.setStatusPayAsk(response.getBody().getStatus());
						txne.setTxReference(response.getBody().getTx_reference());
					    TransactionsSuscribe txn = transactionsSuscribeDao.save(txne);
					    
						return TransSuscribeToTransDto(txn);
					}
				
				}
			}
			
			return null;
		}
	// verifier l'état d'un paiement
	public CheckResponseDto  checkpay(String transactionCode) {
			// create headers
			HttpHeaders headers = new HttpHeaders();
			//set content-type header
			headers.setContentType(MediaType.APPLICATION_JSON);
			//set accept header
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			//create a map for the params
			Map<String,Object> map = new HashMap<>();
			map.put("auth_token", PaySettings.PAYGATE_TOKEN);
			map.put("identifier", transactionCode);
			HttpEntity<Map<String, Object>>entity = new HttpEntity<>(map, headers);
			//send Post request 
			ResponseEntity<CheckResponseDto> response =this.restTemplate.postForEntity(PaySettings.PAYGATE_URL_CHECK, entity, CheckResponseDto.class);
		//check response status code 
			if(response!= null) {
				return response.getBody();
			}
			return null;
	}
	// convert transaction to transactionDto
	public TransactionsDto TransToTransDto(Transactions txn) {
		TransactionsDto trdto= new TransactionsDto();
	    trdto.setIdtransaction(trdto.getIdtransaction());
	    trdto.setCodetrans(txn.getCodetrans());
	    trdto.setPhone(txn.getPhone());
	    trdto.setStatusPayAsk(txn.getStatusPayAsk());
	    trdto.setTxReference(txn.getTxReference());
	    trdto.setOperateur(txn.getOperateur());
	   return trdto;
	}
	// convert transactionSuscribe to transactionDto
	public TransactionsDto TransSuscribeToTransDto(TransactionsSuscribe txn) {
		TransactionsDto trdto= new TransactionsDto();
	    trdto.setIdtransaction(trdto.getIdtransaction());
	    trdto.setCodetrans(txn.getCodetrans());
	    trdto.setPhone(txn.getPhone());
	    trdto.setStatusPayAsk(txn.getStatusPayAsk());
	    trdto.setTxReference(txn.getTxReference());
	    trdto.setOperateur(txn.getOperateur());
	   return trdto;
	}
	
}
