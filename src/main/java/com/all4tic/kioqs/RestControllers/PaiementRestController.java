package com.all4tic.kioqs.RestControllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.all4tic.kioqs.dao.AbonnementDao;
import com.all4tic.kioqs.dao.AgenceAbonnementDao;
import com.all4tic.kioqs.dao.AgenceDao;
import com.all4tic.kioqs.dao.CheckParutionDao;
import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.dao.PayResponseDao;
import com.all4tic.kioqs.dao.SuscribeAgenceDao;
import com.all4tic.kioqs.dao.SuscribeDao;
import com.all4tic.kioqs.dao.TransactionsDao;
import com.all4tic.kioqs.dao.TransactionsSuscribeDao;
import com.all4tic.kioqs.dto.AgenceAbonnementDto;
import com.all4tic.kioqs.dto.CheckResponseDto;
import com.all4tic.kioqs.dto.PayResponse;
import com.all4tic.kioqs.dto.SuscribeAgenceDto;
import com.all4tic.kioqs.dto.TransactionsDto;
import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.AgenceAbonnement;
import com.all4tic.kioqs.models.CheckParution;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Payresponse;
import com.all4tic.kioqs.models.Suscribe;
import com.all4tic.kioqs.models.SuscribeAgence;
import com.all4tic.kioqs.models.Transactions;
import com.all4tic.kioqs.models.TransactionsSuscribe;
import com.all4tic.kioqs.service.LecteurService;
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
	@Autowired
	private AbonnementDao abonnementDao ;
	@Autowired
	private AgenceDao agenceDao ;
	@Autowired 
	private AgenceAbonnementDao agenceAbonnementDao ;
	@Autowired 
	private LecteurDao lecteurDao ;
	@Autowired
	private SuscribeDao suscribeDao ;
	@Autowired
	private TransactionsSuscribeDao transactionsSuscribeDao;
	@Autowired
	private SuscribeAgenceDao suscribeAgenceDao ;
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
	/*
	 * on recupère la liste des types abonnement avec le montant  par agence
	 */
	@GetMapping("agence/{id}")
	public ResponseEntity<List<AgenceAbonnementDto>>getAllAbonnementsByAgence(@PathVariable("id") int id){
		Optional<Agence> agenceOpt = agenceDao.findById(id);
		if(agenceOpt.isPresent()) {
			Agence agence = agenceOpt.get();
			List<AgenceAbonnement> agenceAbns = agenceAbonnementDao.findAllByAgenceAndStatus(agence, 1);
			List<AgenceAbonnementDto> agenceAbnsDto = new ArrayList<>();
			agenceAbns.forEach((AgenceAbonnement a)-> {
				agenceAbnsDto.add(this.agenceAbonnementtoDto(a));
			});
		
			return new ResponseEntity<>(agenceAbnsDto, HttpStatus.OK);
		}
		return null ;
	}
	private AgenceAbonnementDto agenceAbonnementtoDto(AgenceAbonnement a) {
		AgenceAbonnementDto agb = new AgenceAbonnementDto();
		agb.setIdagabn(a.getIdagabn());
		agb.setCode(a.getCode());
		agb.setIdabonnement(a.getAbonnement().getIdabon());
		agb.setIdagence(a.getAgence().getIdagence());
		agb.setNomagence(a.getAgence().getNom());
		agb.setLibabonnement(a.getAbonnement().getLibelle());
		agb.setMontant(a.getMontant());
		agb.setMontantext(a.getMontantext());
		return agb ;
	}
	@GetMapping("abonnement/{codeLecteur}/{idabn}/{tel}")
	public Reponse sendAbonnementPay(@PathVariable String codeLecteur, 
			@PathVariable int idabn, @PathVariable String tel) {
		Reponse reponse = new Reponse();
		Lecteur  lecteur = lecteurDao.findByCode(codeLecteur);
		AgenceAbonnement abg = agenceAbonnementDao.findById(idabn).get();
		LocalDate datedeb = LocalDate.now();
		LocalDate datefin = datedeb.plusDays(abg.getAbonnement().getDuree());
		Suscribe suscribe = new Suscribe();
		suscribe.setLecteur(lecteur);
		suscribe.setDatedeb(datedeb);
		suscribe.setDatefin(datefin);
		suscribe.setCode(""+Utility.generateRandomDigits(7));
		suscribe.setAgenceabonnement(abg);
		Suscribe newSuscribe = suscribeDao.save(suscribe);
		if(newSuscribe !=null) {
		TransactionsDto trdto = payService.sendPayAbonnement(tel, newSuscribe);
		System.out.println(trdto.toString());
		if(trdto!=null) {
			reponse.setCode(""+trdto.getStatusPayAsk());
	         reponse.setStatus(true);
	         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
	         System.out.println(trdto.getCodetrans());
	         reponse.setDatas(""+trdto.getCodetrans());
		}
		
		}
		return reponse;
	}
	// on verifie le paiement de l'abonnment
		@GetMapping("ckechpayabn/{codetrans}")
		public Reponse checkPayAbonnement(@PathVariable("codetrans") String codetrans) {
			Reponse reponse = new Reponse();
			TransactionsSuscribe tr = transactionsSuscribeDao.findByCodetrans(codetrans);
			if(tr!=null) {
			CheckResponseDto chkres = payService.checkpay(codetrans);
			if(chkres !=null) {
				
					if(chkres.getStatus()==0) {
						Suscribe sus = tr.getSuscribe();
						sus.setStatuspay(0);
						suscribeDao.save(sus);
						SuscribeAgence ckp= suscribeAgenceDao.findByLastsuscribe(tr.getSuscribe());
						if(ckp==null) {
							SuscribeAgence pk = suscribeAgenceDao.findByLecteurAndAgenceAndStatus(tr.getSuscribe().getLecteur(), tr.getSuscribe().getAgenceabonnement().getAgence(), 1);
							if(pk==null) {
								pk= new SuscribeAgence();
								pk.setLecteur(tr.getSuscribe().getLecteur());
								pk.setAgence(tr.getSuscribe().getAgenceabonnement().getAgence());
								pk.setDatedeb(tr.getSuscribe().getDatedeb());
								pk.setDatefin(tr.getSuscribe().getDatefin());
							}else {
								if(!pk.getDatefin().isBefore(LocalDate.now())) {
									LocalDate datefin =pk.getDatefin().plusDays(tr.getSuscribe().getAgenceabonnement().getAbonnement().getDuree());
									pk.setDatefin(datefin);
								}else{
									pk.setStatus(2);
									suscribeAgenceDao.save(pk);
									pk= new SuscribeAgence();
									pk.setLecteur(tr.getSuscribe().getLecteur());
									pk.setAgence(tr.getSuscribe().getAgenceabonnement().getAgence());
									pk.setDatedeb(tr.getSuscribe().getDatedeb());
									pk.setDatefin(tr.getSuscribe().getDatefin());
							    }
							}
							pk.setLastsuscribe(tr.getSuscribe());
							
							SuscribeAgence ckpnew=suscribeAgenceDao.save(pk);
							
							reponse.setCode(""+chkres.getStatus());
					         reponse.setStatus(true);
					         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
					         reponse.setDatas(ckpnew.getDatefin());
						}
					}
					 
			       
				
			}
			
			}
			 return reponse;					
		}
		// List des abonnement
		@GetMapping("suscribe/{codeLecteur}")
		public  ResponseEntity<List<SuscribeAgenceDto>> getAllSuscribe(@PathVariable  String codeLecteur){
			Lecteur  lecteur = lecteurDao.findByCode(codeLecteur);
			List<SuscribeAgence> suscribeagences=suscribeAgenceDao.findByLecteurAndStatusOrderByDatefinDesc(lecteur, 1);
			List<SuscribeAgenceDto> suscribeagencesDto = new ArrayList<>();
			suscribeagences.forEach((SuscribeAgence sag)->{
				SuscribeAgenceDto  suscribeagenceDto = new SuscribeAgenceDto();
				suscribeagenceDto.setIdsuscribeagence(sag.getIdsuscribeagence());
				suscribeagenceDto.setAgence(sag.getAgence().getNom());
				suscribeagenceDto.setCodeLecteur(sag.getLecteur().getCode());
				suscribeagenceDto.setDatedeb(sag.getDatedeb());
				suscribeagenceDto.setDatefin(sag.getDatefin());
				suscribeagenceDto.setStatus(sag.getStatus());
				suscribeagencesDto.add(suscribeagenceDto);
			});
			return new ResponseEntity<>(suscribeagencesDto, HttpStatus.OK);
		}
}
