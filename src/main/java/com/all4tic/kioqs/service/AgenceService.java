package com.all4tic.kioqs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dao.AgenceDao;
import com.all4tic.kioqs.dao.CategorieDao;
import com.all4tic.kioqs.dto.AgenceDto;
import com.all4tic.kioqs.models.Agence;

@Service
public class AgenceService {
	@Autowired
	private AgenceDao agenceDao ;
	@Autowired
	private CategorieDao categorieDao;
	
	public AgenceDto addAgence(AgenceDto agenceDto) {
		System.out.println(agenceDto.toString());
		Agence agence = this.agenceDtoToAgence(agenceDto);
		Agence newAgence = agenceDao.save(agence);
		
		if(newAgence!=null)
			return this.agenceToAgenceDto(newAgence);
		return null;
				
	}
	public Agence agenceDtoToAgence(AgenceDto agenceDto) {
		Agence agence = new Agence();
		agence.setCode(agenceDto.getCode());
		agence.setAdresse(agenceDto.getAdresse());
		agence.setDescription(agenceDto.getDescription());
		agence.setEmail(agenceDto.getEmail());
		agence.setNom(agenceDto.getNom());
		agence.setPeriodicite(agenceDto.getPeriodicite());
		agence.setPrixUnit(agenceDto.getPrixUnit());
		agence.setTelephone1(agenceDto.getTelephone1());
		agence.setTelephone2(agenceDto.getTelephone2());
		agence.setNumFlooz(agenceDto.getNumFlooz());
		agence.setNumTmoney(agenceDto.getNumTmoney());
		agence.setIdagence(agenceDto.getIdagence());
		agence.setCategorie(categorieDao.findById(agenceDto.getIdCategorie()).get());
		return agence ;
	}
	public AgenceDto agenceToAgenceDto(Agence agence) {
		AgenceDto agenceDto = new AgenceDto();
		agenceDto.setCode(agence.getCode());
		agenceDto.setAdresse(agence.getAdresse());
		agenceDto.setDescription(agence.getDescription());
		agenceDto.setEmail(agence.getEmail());
		agenceDto.setNom(agence.getNom());
		agenceDto.setPeriodicite(agence.getPeriodicite());
		agenceDto.setPrixUnit(agence.getPrixUnit());
		agenceDto.setTelephone1(agence.getTelephone1());
		agenceDto.setTelephone2(agence.getTelephone2());
		agenceDto.setNumFlooz(agence.getNumFlooz());
		agenceDto.setNumTmoney(agence.getNumTmoney());
		agenceDto.setIdagence(agence.getIdagence());
		agenceDto.setIdCategorie(agence.getCategorie().getIdcategorie());
		return agenceDto ;
	}
	public List<AgenceDto> ListAgence(int status){
		List<Agence> agences = agenceDao.findAllByStatus(status);
		List<AgenceDto> agencesDto = new ArrayList<>();
		agences.forEach((Agence agence)->{
			agencesDto.add(this.agenceToAgenceDto(agence));
		});
		return agencesDto;
	}
	public AgenceDto getAgenceByid(int id) {
		Optional<Agence> agence = agenceDao.findById(id);
		if(agence.isPresent())
			return this.agenceToAgenceDto(agence.get());
	return null;
	}
	
}
