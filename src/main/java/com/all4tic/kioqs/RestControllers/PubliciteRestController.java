package com.all4tic.kioqs.RestControllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.kioqs.dao.VpublicitezoneDao;
import com.all4tic.kioqs.dao.ZoneDao;
import com.all4tic.kioqs.dao.ZonePubliciteDao;
import com.all4tic.kioqs.dto.ZoneRequest;
import com.all4tic.kioqs.models.Jobs;
import com.all4tic.kioqs.models.Publicite;
import com.all4tic.kioqs.models.Zone;
import com.all4tic.kioqs.models.ZonePublicite;
import com.all4tic.kioqs.models.vpublicitezone;
import com.all4tic.kioqs.service.FileStorageService;
import com.all4tic.kioqs.service.PubliciteService;
import com.all4tic.kioqs.utilities.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/pub/")
@CrossOrigin(origins = "*")
public class PubliciteRestController {
	@Autowired
	private PubliciteService  publiciteService ;
	@Autowired
	private ZoneDao zoneDao ;
	@Autowired
	private ZonePubliciteDao zonePubliciteDao ;
	@Autowired
	private FileStorageService fileStorageService ;
	@Autowired
	private VpublicitezoneDao vpublicitezoneDao;
	
	@PostMapping("add")
	public ResponseEntity<?> addPublicite(@RequestParam("imageFile") MultipartFile imageFile, 
			 @RequestParam("description") String  description,
			 @RequestParam("dateDebut") String dateDebut,
			 @RequestParam("dateFin") String dateFin,
			 @RequestParam("zone") String zone ){
		System.out.println(zone);
		String [] idzone = this.removeLastCharacter(zone).split(",");
		System.out.println(idzone.length);
		Publicite publicite = new Publicite();
		publicite.setDescription(description);
		String code = ""+Math.abs(Utility.generateRandomDigits(6));
		publicite.setCode(code);
		List<ZonePublicite> zps =new ArrayList<>();
		for(int i=0;  i < idzone.length; i++) {
			System.out.println(idzone[i]);
			if(Integer.parseInt(idzone[i]) > 0 ) {
				Zone zn = zoneDao.findById(Integer.parseInt(idzone[i])).get();
				ZonePublicite zp = new ZonePublicite();
				zp.setDatedebut(LocalDate.parse(dateDebut));
				zp.setDatefin(LocalDate.parse(dateFin));
				zp.setPublicite(publicite);
				zp.setZone(zn);
				zps.add(zp);
			}
		}
		
		publicite.setZonepubs(zps);
		if(imageFile!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"."+extension.trim();
		    Path root=  Paths.get("uploads/img/pubs");
		    publicite.setImageurl(root+"/"+newFilename);
		}
		System.out.println(publicite);
		Publicite newp = publiciteService.addPublicite(publicite);
		if(newp != null) {
			fileStorageService.save(imageFile, newp);
			zps.forEach(zp->{
				zp.setPublicite(newp);
				zonePubliciteDao.save(zp);
			});
		}
		return new ResponseEntity<>(newp, HttpStatus.OK);
	}
	@GetMapping("zones")
	public  ResponseEntity<List<Zone>>getAllZone(){
		return new ResponseEntity<>(zoneDao.findAllByStatus(1), HttpStatus.OK);
	}
	public  String removeLastCharacter(String str) {
		   String result = Optional.ofNullable(str)
		   .filter(sStr -> sStr.length() != 0)
		   .map(sStr -> sStr.substring(0, sStr.length() - 1))
		   .orElse(str);
		   return result;
		}
	@GetMapping("all/{offset}/{limit}")
	public ResponseEntity<Page<vpublicitezone>> actionGetAllPubs(@PathVariable("offset")int offset,
			@PathVariable("limit") int limit){
		Pageable p = PageRequest.of(offset,limit);
		Page<vpublicitezone> slicevpublicitezone = vpublicitezoneDao.findAll(p);
		return new ResponseEntity<>(slicevpublicitezone, HttpStatus.OK);
	}
}
