package com.all4tic.kioqs.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.kioqs.dto.LecteurDto;
import com.all4tic.kioqs.service.LecteurService;

@RestController
@RequestMapping("/api/lecteur/")
@CrossOrigin(origins = "*")
public class LecteurRestController {
	@Autowired 
	private LecteurService lecteurService;
	@GetMapping("all")
	public ResponseEntity<List<LecteurDto>> getAllLecteurs(){
		return new ResponseEntity<>(lecteurService.listAbonnes(1), HttpStatus.OK);
	}

}
