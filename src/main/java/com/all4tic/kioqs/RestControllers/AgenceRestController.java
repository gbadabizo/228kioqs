package com.all4tic.kioqs.RestControllers;

import java.util.List;

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

import com.all4tic.kioqs.dao.CategorieDao;
import com.all4tic.kioqs.dto.AgenceDto;
import com.all4tic.kioqs.models.Categorie;
import com.all4tic.kioqs.service.AgenceService;

@RestController
@RequestMapping("/api/agence/")
@CrossOrigin(origins = "*")
public class AgenceRestController {
	@Autowired
	private AgenceService agenceService ;
	@Autowired
	private CategorieDao categorieDao;
		
	@GetMapping("all")
	public ResponseEntity<List<AgenceDto>>getAllAgences(){
		return new ResponseEntity<>(agenceService.ListAgence(1), HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<AgenceDto>getAgence(@PathVariable int id){
		return new ResponseEntity<>(agenceService.getAgenceByid(id),HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<AgenceDto>AddAgence(@RequestBody AgenceDto agenceDto){
		return new ResponseEntity<>(agenceService.addAgence(agenceDto),HttpStatus.OK);
	}
	@GetMapping("categories")
	public ResponseEntity<List<Categorie>>getAllCatageorie(){
		return new ResponseEntity<>(categorieDao.findAllByStatus(1), HttpStatus.OK);
	}
}
