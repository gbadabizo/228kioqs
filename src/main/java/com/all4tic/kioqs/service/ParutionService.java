package com.all4tic.kioqs.service;

import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dto.ParutionDto;
import com.all4tic.kioqs.models.Parution;

@Service
public class ParutionService {
 public ParutionDto ParutionToParutionDto(Parution p) {
	 ParutionDto pdto = new ParutionDto();
	 pdto.setCode(p.getCode());
	 pdto.setIdparution(p.getIdparution());
	 pdto.setDateParution(p.getDateParution());
	 pdto.setNumParution(p.getNumParution());
	 pdto.setPremierTitre(p.getPremierTitre());
	 pdto.setDescPremierTitre(p.getDescPremierTitre());
	 pdto.setSecondTitre(p.getSecondTitre());
	 pdto.setDescSecondTitre(p.getDescSecondTitre());
	 pdto.setUrlFichier(p.getUrlFichier());
	 pdto.setUrlImage(p.getUrlImage());
	 pdto.setIdagence(p.getAgence().getIdagence());
	 pdto.setPublished(p.getPublished());
	 pdto.setValidated(p.getValidated());
	 pdto.setLibelleAgence(p.getAgence().getNom());
	 pdto.setPrixUnit(p.getAgence().getPrixUnit());
	 return pdto;
 }
}
