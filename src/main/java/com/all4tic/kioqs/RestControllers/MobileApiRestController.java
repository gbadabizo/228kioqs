package com.all4tic.kioqs.RestControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.kioqs.dao.AgenceDao;
import com.all4tic.kioqs.dao.CategorieDao;
import com.all4tic.kioqs.dao.CheckParutionDao;
import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.dao.PayResponseDao;
import com.all4tic.kioqs.dao.TransactionsDao;
import com.all4tic.kioqs.dto.AgenceDto;
import com.all4tic.kioqs.dto.CheckResponseDto;
import com.all4tic.kioqs.dto.ParutionDto;
import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.Categorie;
import com.all4tic.kioqs.models.CheckParution;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Payresponse;
import com.all4tic.kioqs.models.Transactions;
import com.all4tic.kioqs.service.AgenceService;
import com.all4tic.kioqs.service.FileStorageService;
import com.all4tic.kioqs.service.LecteurService;
import com.all4tic.kioqs.service.ParutionService;
import com.all4tic.kioqs.service.PayService;
import com.all4tic.kioqs.utilities.Code;
import com.all4tic.kioqs.utilities.Reponse;

@RestController
@RequestMapping("/mobile/parution/")
@CrossOrigin(origins = "*")
public class MobileApiRestController {
	@Autowired
	private ParutionDao parutionDao;
	@Autowired
	private FileStorageService fileStorageService ;
	@Autowired
	private ParutionService parutionService;
	@Autowired
	private CheckParutionDao checkParutionDao;
	@Autowired
	private LecteurDao lecteurDao;
	@Autowired
	private TransactionsDao transactionsDao;
	@Autowired
	private PayService payService;
	@Autowired
	private PayResponseDao payResponseDao;
	@Autowired
	private AgenceService agenceService ;
	@Autowired
	private AgenceDao agenceDao ;
	@Autowired 
	private CategorieDao categorieDao ;
	@GetMapping("pdf/{id}")
	public ResponseEntity<Resource> getPDF(@PathVariable("id") long id ){
		Optional<Parution> p = parutionDao.findById(id);
		if(p.isPresent()) {
			Parution parution = p.get();
			System.out.println(parution.getUrlFichier());
			Resource file = fileStorageService.load(parution.getUrlFichier());
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		}
		return null;
		
	}
	@GetMapping("image/{id}")
	public ResponseEntity<Resource> getImage(@PathVariable("id") long id ){
		Optional<Parution> p = parutionDao.findById(id);
		if(p.isPresent()) {
			Parution parution = p.get();
			System.out.println(parution.getUrlImage());
			Resource file = fileStorageService.load(parution.getUrlImage());
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		}
		return null;
		
	}
	@GetMapping("all")
	public ResponseEntity<List<ParutionDto>>getAllPartution(){
		List<Parution> parutions = parutionDao.findAllByPublishedOrderByDateParutionDesc(0);
		List<ParutionDto> parutionsDto = new ArrayList<ParutionDto>();
		if(parutions!=null) {
			parutions.forEach((Parution p)->{
				parutionsDto.add(parutionService.ParutionToParutionDto(p));
			});
		}
		return new ResponseEntity<>(parutionsDto, HttpStatus.OK);
	}
	@GetMapping("all/{offset}/{limit}")
	public ResponseEntity<List<ParutionDto>>getAllPartutionWithlimit(@PathVariable("offset")int offset,
			@PathVariable("limit") int limit){
		Pageable sortedByDateParutionDesc = PageRequest.of(offset,limit, Sort.by("dateParution").descending());
		//List<Parution> parutions = parutionDao.findAllByPublishedOrderByDateParutionDesc(0);
		Slice<Parution> sliceparutions = parutionDao.findAllByPublished(0, sortedByDateParutionDesc);
		List<Parution> parutions = sliceparutions.getContent();
		List<ParutionDto> parutionsDto = new ArrayList<ParutionDto>();
		if(parutions!=null) {
			parutions.forEach((Parution p)->{
				parutionsDto.add(parutionService.ParutionToParutionDto(p));
			});
		}
		return new ResponseEntity<>(parutionsDto, HttpStatus.OK);
	}
	@GetMapping("Ckeck/{idparution}/{codeLecteur}")
	public Reponse checkParutionPayement(@PathVariable("idparution") long idparution,
			@PathVariable("codeLecteur") String codeLecteur) {
		 Reponse reponse = new Reponse();
		CheckParution chkp = new CheckParution();
		Lecteur l = lecteurDao.findByCode(codeLecteur); // on recupère le lecteur 
		Optional<Parution> opp = parutionDao.findById(idparution);  
		if(opp.isPresent()) {
			Parution p = opp.get();// on recupère la parution
			Transactions tr2 = transactionsDao.findByParutionAndLecteurAndStatusPayAndStatus(p, l,1,1);// on recupère la transaction
			Transactions tr = transactionsDao.findByParutionAndLecteurAndStatusPay(p, l,0);
			chkp = checkParutionDao.findByParutionAndLecteur(p, l);
			if(chkp!=null) {
				 reponse.setCode(""+Code.SUCCESSFUL_CODE);
		         reponse.setStatus(true);
		         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
		         reponse.setDatas(true);
			}else if((tr!=null)){
				 reponse.setCode(""+Code.SUCCESSFUL_CODE);
		         reponse.setStatus(true);
		         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
		         reponse.setDatas(true);
			}else if((tr2!=null)&&(checkTransaction(tr2.getCodetrans()))) {
				 reponse.setCode(""+Code.SUCCESSFUL_CODE);
		         reponse.setStatus(true);
		         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
		         reponse.setDatas(true);
			}
			else{
				reponse.setCode(""+Code.NOT_FOUND_CODE);
		         reponse.setStatus(true);
		         reponse.setMessage(Code.NOT_FOUND_MESSAGE);
		         reponse.setDatas(false);
			}
		}
		return reponse;
	}
	// verification de paiement
	public   boolean checkTransaction(String codetrans) {
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
				tr.setStatusPay(newpayres.getStatuspay());
				transactionsDao.save(tr);// update transaction
				if(newpayres.getStatuspay()==0) {
					CheckParution ckp= checkParutionDao.findByParutionAndLecteur(tr.getParution(), tr.getLecteur());
					if(ckp==null) {
						CheckParution pk= new CheckParution();
						pk.setLecteur(tr.getLecteur());
						pk.setParution(tr.getParution());
						CheckParution ckpnew=checkParutionDao.save(pk);
						if(ckpnew!=null)
							return true;
					}
					return true ;
				}
				
			}
			
		}
		
		}
		return false;
	}
	@GetMapping("agences")
	public ResponseEntity<List<AgenceDto>>getAllAgences(){
		return new ResponseEntity<>(agenceService.ListAgence(1), HttpStatus.OK);
	}
	@GetMapping("all/{idagence}/{offset}/{limit}")
	public ResponseEntity<List<ParutionDto>>getAllPartutionByAgence(@PathVariable("idagence") int idagence,
			@PathVariable("offset") int offset, @PathVariable("limit") int limit
			){
		Pageable sortedByDateParutionDesc = PageRequest.of(offset,limit, Sort.by("dateParution").descending());
		Slice<Parution> parutionsSlice = parutionDao.findAllByAgenceAndStatus(agenceService
				.agenceDtoToAgence(agenceService.getAgenceByid(idagence)), 1,sortedByDateParutionDesc );
		List<Parution> parutions = parutionsSlice.getContent();
		List<ParutionDto> parutionsDto = new ArrayList<ParutionDto>();
		if(parutions!=null) {
			parutions.forEach((Parution p)->{
				parutionsDto.add(parutionService.ParutionToParutionDto(p));
			});
		}
		return new ResponseEntity<>(parutionsDto, HttpStatus.OK);
	}
	@GetMapping("categ/{idcateg}/{offset}/{limit}")
	public ResponseEntity<List<ParutionDto>>getAllPartutionByCategorie(@PathVariable("idcateg") int idcateg,
			@PathVariable("offset") int offset, @PathVariable("limit") int limit
			){
		Categorie c = categorieDao.findById(idcateg).get();
		List<ParutionDto> parutionsDto = new ArrayList<ParutionDto>();
		List<Agence> agences = agenceDao.findAllByStatusAndCategorie(1, c);
		for(Agence agence : agences) {
			Pageable sortedByDateParutionDesc = PageRequest.of(offset,limit, Sort.by("dateParution").descending());
			Slice<Parution> parutionsSlice = parutionDao.findAllByAgenceAndStatus(agenceService
					.agenceDtoToAgence(agenceService.getAgenceByid(agence.getIdagence())), 1,sortedByDateParutionDesc );
			List<Parution> parutions = parutionsSlice.getContent();
			if(parutions!=null) {
				parutions.forEach((Parution p)->{
					parutionsDto.add(parutionService.ParutionToParutionDto(p));
				});
			}
		}
		return new ResponseEntity<>(parutionsDto, HttpStatus.OK);
	}
	// liste des transactions d'un lecteur
	@GetMapping("trans/{lecteur}/{offset}/{limit}")
	public ResponseEntity<List<Transactions>> getAllTransactionsByLecteur(@PathVariable("lecteur") String lecteur,
			@PathVariable("offset") int offset, @PathVariable("limit") int limit){
		Lecteur l = lecteurDao.findByCode(lecteur);
		Pageable sortedByDateopDesc = PageRequest.of(offset,limit, Sort.by("dateop").descending());
		Slice<Transactions>transSlice = transactionsDao.findAllByLecteur(l, sortedByDateopDesc);
		List<Transactions> trans = transSlice.getContent();
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
}
