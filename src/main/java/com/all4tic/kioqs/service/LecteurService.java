package com.all4tic.kioqs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dao.LecteurDao;
import com.all4tic.kioqs.dto.LecteurDto;
import com.all4tic.kioqs.dto.RequestLecteur;
import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.utilities.Utility;

@Service
public class LecteurService {
	@Autowired 
	private LecteurDao lecteurDao;
	public LecteurDto save(RequestLecteur requestlecteur) {
		Lecteur l = new Lecteur();
		l.setNom(requestlecteur.getNom());
		l.setPrenoms(requestlecteur.getPrenoms());
		l.setTelephone(requestlecteur.getTelephone());
		String code ="";
		code=Utility.generateCodeLecteur();
		Lecteur old=null;
		old= lecteurDao.findByCode(code);
		//check code
		while (old!=null) {
			 code = Utility.generateCodeLecteur();
			 old = lecteurDao.findByCode(code);
		}
		l.setCode(code);
		Lecteur newlecteur = lecteurDao.save(l);
		return this.LecteurToLecteurDto(newlecteur);	
		
	}
	public LecteurDto getLecteurByCode(String code) {
		return this.LecteurToLecteurDto(lecteurDao.findByCode(code));
	}
	public LecteurDto LecteurToLecteurDto(Lecteur l) {
		if(l!=null) {
			LecteurDto ldto = new LecteurDto();
					ldto.setIdlecteur(l.getIdlecteur());
					ldto.setNom(l.getNom());
					ldto.setCode(l.getCode());
					ldto.setPrenoms(l.getPrenoms());
					ldto.setTelephone(l.getTelephone());
					ldto.setIsvalidated(l.getIsvalidated());
			return ldto;
		}
		return null;
	}
	
}
