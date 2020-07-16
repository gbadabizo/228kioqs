package com.all4tic.kioqs.RestControllers;

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

import com.all4tic.kioqs.dao.ActivationDao;
import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dto.LecteurDto;
import com.all4tic.kioqs.dto.RequestLecteur;
import com.all4tic.kioqs.models.Activation;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.service.LecteurService;
import com.all4tic.kioqs.utilities.Code;
import com.all4tic.kioqs.utilities.Reponse;
import com.all4tic.kioqs.utilities.Utility;

@RestController
@RequestMapping("/mobile/suscribe/")
@CrossOrigin(origins = "*")
public class SuscribeRestController {
	@Autowired
	private LecteurService lecteurService;
	@Autowired
	private LecteurDao lecteurDao;
	@Autowired 
	private ActivationDao activationDao;
	
	@GetMapping("lecteur/{code}")
	public ResponseEntity<LecteurDto>getLecteurByCode(@PathVariable("code") String code){
		System.out.println("code: "+code);
		return new ResponseEntity<>(lecteurService.getLecteurByCode(code), HttpStatus.OK);
	}
	@PostMapping("lecteur/add")
	public Reponse addLecteur(@RequestBody RequestLecteur requestLecteur){
				
		Reponse reponse = new Reponse();
		reponse.setStatus(false);
		reponse.setCode(""+Code.FAIL_CODE);
		// verifions l'existence du code lecteur
		Lecteur l =  lecteurDao.findByTelephone(requestLecteur.getTelephone());
		if(l!=null) {
			reponse.setCode(""+Code.EXIST_CODE);
			reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
			reponse.setStatus(true);
			reponse.setDatas(l.getCode());
		}else {
			LecteurDto ldto= lecteurService.save(requestLecteur);
			reponse.setCode(""+Code.SUCCESSFUL_CODE);
			reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
			reponse.setStatus(true);
			reponse.setDatas(ldto.getCode());
		}
		
		return reponse;
	}
	
	@GetMapping("sendsms/{codeLecteur}")
    public  Reponse  sendSMS(@PathVariable String codeLecteur){
        Lecteur l = lecteurDao.findByCode(codeLecteur);
        		System.out.println(l.toString());
        String code = null;
        Reponse reponse = new Reponse();
        if(l!=null){
             code =""+ Utility.generateRandomDigits(4);
            Activation activation = new Activation();
            activation.setLecteur(l);
            activation.setCode(code);
         Activation newActivation=   activationDao.save(activation);
          //  SendSms.send(SendSms.apiKey,atelier.getTelephone(),code,"TELAA",""); 
         reponse.setCode(""+Code.SUCCESSFUL_CODE);
         reponse.setStatus(true);
         reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
         reponse.setDatas(code);
         
        }
       return reponse;
    }
    @GetMapping("confirm/{codeLecteur}/{code}")
    public Reponse confirmAtelier(@PathVariable String  codeLecteur, @PathVariable String code){
    	Reponse reponse = new Reponse();
        Lecteur l = lecteurDao.findByCode(codeLecteur);
        Activation activation = activationDao.findActivationByLecteurAndCode(l, code);
        if(activation!=null) {
            l.setIsvalidated(1);  
            lecteurDao.save(l);
            activation.setStatus(1);
            activationDao.save(activation);
            reponse.setCode(""+Code.SUCCESSFUL_CODE);
            reponse.setStatus(true);
            reponse.setMessage(Code.SUCCESSFUL_MESSAGE);
            reponse.setDatas(activation);
        }
        return  reponse;
    }
}
