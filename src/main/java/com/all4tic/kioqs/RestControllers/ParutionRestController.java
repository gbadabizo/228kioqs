package com.all4tic.kioqs.RestControllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.dto.ParutionDto;
import com.all4tic.kioqs.dto.RequestParution;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.service.AgenceService;
import com.all4tic.kioqs.service.FileStorageService;
import com.all4tic.kioqs.service.ParutionService;

@RestController
@RequestMapping("/api/parution/")
@CrossOrigin(origins = "*")
public class ParutionRestController {
	@Autowired
	private AgenceService agenceService;
	@Autowired
	private ParutionDao parutionDao;
	@Autowired
	private FileStorageService fileStorageService ;
	@Autowired
	private ParutionService parutionService;
	
	@PostMapping("add")
	public ResponseEntity<ParutionDto> addParution(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("pdfFile") MultipartFile pdfFile, @RequestParam("code") String code,
			 @RequestParam("numParution") String  numParution,
			 @RequestParam("dateParution") String  dateParution,
			 @RequestParam("premierTitre") String  premierTitre,
			 @RequestParam("secondTitre") String  secondTitre,
			 @RequestParam("descPremierTitre") String  descPremierTitre,
			 @RequestParam("descSecondTitre") String  descSecondTitre,
			 @RequestParam("idagence") int idagence
			){
		Parution parution = new Parution();
		parution.setAgence(agenceService.agenceDtoToAgence(agenceService.getAgenceByid(idagence)));
		parution.setCode(code);
		parution.setDateParution(LocalDate.parse(dateParution));
		parution.setPremierTitre(premierTitre);
		parution.setSecondTitre(secondTitre);
		parution.setDescPremierTitre(descPremierTitre);
		parution.setDescSecondTitre(descSecondTitre);
		parution.setNumParution(numParution);
		
		if(imageFile!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = parution.getCode()+"."+extension.trim();
		    Path root=  Paths.get("uploads/img/"+parution.getAgence().getCode().trim());
		    parution.setUrlImage(root+"/"+newFilename);
		}
		if(pdfFile!=null) {
			String originFileName= pdfFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = parution.getCode()+"."+extension.trim();
		    Path root=  Paths.get("uploads/pdf/"+parution.getAgence().getCode().trim());
		    parution.setUrlFichier(root+"/"+newFilename);
		}
		Parution newparution=	parutionDao.save(parution);
		if(newparution!=null) {
			fileStorageService.save(imageFile, newparution, 2);
			fileStorageService.save(pdfFile, newparution, 1);
		}

	return new ResponseEntity<>(parutionService.ParutionToParutionDto(newparution), HttpStatus.OK);
		
	}
	@GetMapping("all/{idagence}")
	public ResponseEntity<List<ParutionDto>>getAllPartutionByAgence(@PathVariable("idagence") int idagence ){
		List<Parution> parutions = parutionDao.findAllByAgenceAndStatus(agenceService
				.agenceDtoToAgence(agenceService.getAgenceByid(idagence)), 1);
		List<ParutionDto> parutionsDto = new ArrayList<ParutionDto>();
		if(parutions!=null) {
			parutions.forEach((Parution p)->{
				parutionsDto.add(parutionService.ParutionToParutionDto(p));
			});
		}
		return new ResponseEntity<>(parutionsDto, HttpStatus.OK);
	}
	@GetMapping("{idparution}")
	public ResponseEntity<ParutionDto>getParution(@PathVariable("idparution") long idparution){
		Optional<Parution> p = parutionDao.findById(idparution);
		if(p.isPresent()) {
			return  new ResponseEntity<>(parutionService.ParutionToParutionDto(p.get()), HttpStatus.OK);
		}
		return null ;
	}
	@PostMapping("edit")
	public ResponseEntity<ParutionDto> editParution(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("pdfFile") MultipartFile pdfFile, @RequestParam("code") String code,
			 @RequestParam("numParution") String  numParution,
			 @RequestParam("dateParution") String  dateParution,
			 @RequestParam("premierTitre") String  premierTitre,
			 @RequestParam("secondTitre") String  secondTitre,
			 @RequestParam("descPremierTitre") String  descPremierTitre,
			 @RequestParam("descSecondTitre") String  descSecondTitre,
			 @RequestParam("idagence") int idagence,
			 @RequestParam("idParution") long idParution 
			){
		System.out.println("code: "+code);
		Optional<Parution> par = parutionDao.findById(idParution);
		if(par.isPresent()) {
			Parution parution= par.get();
			parution.setAgence(agenceService.agenceDtoToAgence(agenceService.getAgenceByid(idagence)));
			parution.setCode(code);
			parution.setDateParution(LocalDate.parse(dateParution));
			parution.setPremierTitre(premierTitre);
			parution.setSecondTitre(secondTitre);
			parution.setDescPremierTitre(descPremierTitre);
			parution.setDescSecondTitre(descSecondTitre);
			parution.setNumParution(numParution);
		
		if(imageFile!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = parution.getCode()+"."+extension.trim();
		    Path root=  Paths.get("uploads/img/"+parution.getAgence().getCode().trim());
		    parution.setUrlImage(root+"/"+newFilename);
		}
		if(pdfFile!=null) {
			String originFileName= pdfFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = parution.getCode()+"."+extension.trim();
		    Path root=  Paths.get("uploads/pdf/"+parution.getAgence().getCode().trim());
		    parution.setUrlFichier(root+"/"+newFilename);
		}
		Parution newparution=	parutionDao.save(parution);
		if(newparution!=null) {
			fileStorageService.save(imageFile, newparution, 2);
			fileStorageService.save(pdfFile, newparution, 1);
		}

				return new ResponseEntity<>(parutionService.ParutionToParutionDto(newparution), HttpStatus.OK);
		}
		return null;
	}
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
	

}
