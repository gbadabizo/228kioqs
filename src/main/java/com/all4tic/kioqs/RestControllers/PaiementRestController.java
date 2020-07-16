package com.all4tic.kioqs.RestControllers;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.all4tic.kioqs.dao.CheckParutionDao;
import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.dao.PayResponseDao;
import com.all4tic.kioqs.dao.TransactionsDao;
import com.all4tic.kioqs.dto.CheckResponseDto;
import com.all4tic.kioqs.dto.GetPayResponse;
import com.all4tic.kioqs.dto.PayResponse;
import com.all4tic.kioqs.dto.TransactionsDto;
import com.all4tic.kioqs.models.CheckParution;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Payresponse;
import com.all4tic.kioqs.models.Transactions;
import com.all4tic.kioqs.service.PayService;
import com.all4tic.kioqs.utilities.Code;
import com.all4tic.kioqs.utilities.PaySettings;
import com.all4tic.kioqs.utilities.Reponse;
import com.all4tic.kioqs.utilities.Utility;


@RestController
@RequestMapping("/mobile/pay/")
@CrossOrigin(origins = "*")
public class PaiementRestController {
	@Autowired
	private PayService payService;
	@Autowired 
	private TransactionsDao transactionsDao ;
	@Autowired
	private PayResponseDao payResponseDao;
	@Autowired
	private CheckParutionDao checkParutionDao ;
	// On envoie une demenade de payement
	@GetMapping("send/{tel}/{idparution}/{codeLecteur}")
	public Reponse sendPay(@PathVariable("tel") String numtel , @PathVariable("idparution")long idparution ,
			@PathVariable("codeLecteur") String codeLecteur) { 
		TransactionsDto trdto = payService.sendPay(numtel, idparution, codeLecteur);
		System.out.println(trdto.toString());
		 Reponse reponse = new Reponse();
		if(trdto!=null) {
			reponse.setCode(""+trdto.getStatusPayAsk());
	         reponse.setStatus(true);
	         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
	         System.out.println(trdto.getCodetrans());
	         reponse.setDatas(""+idparution);
		}
		return reponse;
	}
	// on verifie le paiement
	@GetMapping("ckechpay/{codetrans}")
	public Reponse checkPay(@PathVariable("codetrans") String codetrans) {
		Reponse reponse = new Reponse();
		Transactions tr = transactionsDao.findByCodetrans(codetrans);
		if(tr!=null) {
		CheckResponseDto chkres = payService.checkpay(codetrans);
		if(chkres !=null) {
			Payresponse  payres = new Payresponse();
			payres.setDatepay(chkres.getDatetime());
			payres.setMethodpay(chkres.getPayment_method());
			payres.setPayref(chkres.getPayment_reference());
			payres.setStatuspay(chkres.getStatus());
			payres.setTxreference(chkres.getTx_reference());
			payres.setTransactions(tr);
			Payresponse  newpayres =payResponseDao.save(payres);
			if(newpayres!=null) {
				if(newpayres.getStatuspay()==0) {
					CheckParution ckp= checkParutionDao.findByParutionAndLecteur(tr.getParution(), tr.getLecteur());
					if(ckp==null) {
						CheckParution pk= new CheckParution();
						pk.setLecteur(tr.getLecteur());
						pk.setParution(tr.getParution());
						CheckParution ckpnew=checkParutionDao.save(pk);
					}
				}
				 reponse.setCode(""+newpayres.getStatuspay());
		         reponse.setStatus(true);
		         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
		         reponse.setDatas(newpayres.getPayref());
		        return reponse;
			}
		}
		
		}
		return null;
		
		
	}
	@PostMapping("/paiement/callback")
	public Reponse getPaiement(@RequestBody GetPayResponse getPayResponse) {
		Transactions trans = transactionsDao.findByCodetrans(getPayResponse.getIdentifier());
		Reponse reponse = new Reponse();
		if(trans != null) {
			Payresponse  payres = new Payresponse();
			payres.setDatepay(LocalDate.now());
			payres.setMethodpay(getPayResponse.getPayment_method());
			payres.setPayref(getPayResponse.getPayment_reference());
			payres.setStatuspay(0);
			payres.setTxreference(getPayResponse.getTx_reference());
			payres.setTransactions(trans);
			Payresponse  newpayres =payResponseDao.save(payres);
			if((newpayres != null) && (newpayres.getStatuspay()==0)) {
				
			}
		}
		return reponse ;
	}
	
}
