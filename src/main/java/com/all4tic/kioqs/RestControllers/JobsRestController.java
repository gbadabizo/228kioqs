package com.all4tic.kioqs.RestControllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.kioqs.dao.JobCategorieDao;
import com.all4tic.kioqs.dao.JobsDao;
import com.all4tic.kioqs.dto.CategorieRequest;
import com.all4tic.kioqs.dto.JobsDto;
import com.all4tic.kioqs.models.JobCategorie;
import com.all4tic.kioqs.models.Jobs;
import com.all4tic.kioqs.service.FileStorageService;
import com.all4tic.kioqs.service.JobsServiceImpl;
import com.all4tic.kioqs.utilities.Utility;

@RestController
@RequestMapping("/api/job/")
@CrossOrigin(origins = "*")
public class JobsRestController {
	@Autowired
	private JobCategorieDao  categorieRepository ;
	@Autowired
	private FileStorageService fileStorageService ;
	@Autowired
	private JobsDao jobsDao;
	@Autowired
	private JobsServiceImpl jobsServiceImpl ;
	
	
	@GetMapping("categories")
	public ResponseEntity<List<JobCategorie>> actionGetAllCategories(){
		return new ResponseEntity<> (categorieRepository.findAllByStatus(1), HttpStatus.OK);
	}
	
	@PostMapping("categorie/add")
	public ResponseEntity<JobCategorie> actionAddCategorie(@RequestBody CategorieRequest categorieRequest){
		JobCategorie categorie = new JobCategorie();
		categorie.setCode(Utility.generateCodeCategorie());
		categorie.setDescription(categorieRequest.getDescription());
		categorie.setLibelle(categorieRequest.getLibelle());
		JobCategorie newCategorie = categorieRepository.save(categorie);
		return new ResponseEntity<>(newCategorie, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<JobsDto> actionAddJobs(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam(name="pdfFile", required=false) MultipartFile pdfFile, @RequestParam("titre") String titre,
			 @RequestParam("description") String  description,
			 @RequestParam("profil") String  profil,
			 @RequestParam("typecontrat") String  typecontrat,
			 @RequestParam("pays") String  pays,
			 @RequestParam("adrjob") String  adrjob,
			 @RequestParam("dateannonce") String  dateannonce,
			 @RequestParam("idcategorie") int idcategorie,
			 @RequestParam("dateCloture") String datecloture,
			 @RequestParam("source") String source
			){
		Jobs jobs = new Jobs();
		String code = ""+Math.abs(Utility.generateRandomDigits(8));
		jobs.setAdrjob(adrjob);
		jobs.setDescription(description);
		jobs.setCode(code);
		jobs.setPays(pays);
		jobs.setSource(source);
		jobs.setTitre(titre);
		jobs.setJobCategorie(categorieRepository.findById(idcategorie).get());
		jobs.setProfil(profil);
		jobs.setTypecontrat(typecontrat);
		jobs.setDateannonce(LocalDate.parse(dateannonce));
		jobs.setDatecloture(LocalDate.parse(datecloture));
		jobs.setDatecreated(LocalDate.now());
		
		if(imageFile!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"."+extension.trim();
		    Path root=  Paths.get("uploads/img/"+jobs.getJobCategorie().getCode().trim());
		    jobs.setUrlImage(root+"/"+newFilename);
		}
		System.out.print(pdfFile);
		if(pdfFile!=null) {
			String originFileName= pdfFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename =code+"."+extension.trim();
		    Path root=  Paths.get("uploads/pdf/"+jobs.getJobCategorie().getCode().trim());
		    jobs.setUrlFichier(root+"/"+newFilename);
		}
		Jobs newJobs = jobsDao.save(jobs);
		if(newJobs!=null) {
			fileStorageService.save(imageFile, newJobs, 2);
			if(pdfFile!=null)
			  fileStorageService.save(pdfFile, newJobs, 1);
		}
		return new ResponseEntity<>(jobsServiceImpl.JobsToJobsDto(newJobs), HttpStatus.OK);
	}

	@GetMapping("all/{offset}/{limit}")
	public ResponseEntity<Page<Jobs>> actionGetAllJobs(@PathVariable("offset")int offset,
			@PathVariable("limit") int limit){
		Pageable sortedByDateJobsDesc = PageRequest.of(offset,limit, Sort.by("datecreated").descending());
	//	Slice<Jobs> slicejobs = jobsRepository.findAllByStatus(1, sortedByDateJobsDesc);
		Page<Jobs> slicejobs = jobsDao.findAllByStatus(1, sortedByDateJobsDesc);
		//List<Jobs> jobs = slicejobs.getContent();
	//	List<JobsDto> jobsDtos = new ArrayList<>();
		/*for(Jobs job : jobs) {
			jobsDtos.add(jobsServiceImpl.JobsToJobsDto(job));
		}*/
		return new ResponseEntity<>(slicejobs, HttpStatus.OK);
	}
	@GetMapping("categ/{idcateg}")
	public ResponseEntity<List<JobsDto>> actionGetAllJobsByCategorie(@PathVariable("idcateg")int idcateg
			){
		JobCategorie categ = categorieRepository.findById(idcateg).get();
		List<Jobs> jobs =jobsDao.findTop10ByStatusAndJobCategorieOrderByDateclotureDesc(1, categ);
		List<JobsDto> jobsDtos = new ArrayList<>();
		for(Jobs job : jobs) {
			jobsDtos.add(jobsServiceImpl.JobsToJobsDto(job));
		}
		return new ResponseEntity<>(jobsDtos, HttpStatus.OK);
	}
	@GetMapping("detail/{id}")
	public ResponseEntity<JobsDto> actionGetJob(@PathVariable("id")long id){
		Optional<Jobs> job = jobsDao.findById(id);
		JobsDto jobsDto= new JobsDto() ;
		if(job.isPresent()) {
			jobsDto=jobsServiceImpl.JobsToJobsDto(job.get());
		}
		return new ResponseEntity<>(jobsDto, HttpStatus.OK);
	}
	

	@GetMapping("pdf/{id}")
	public ResponseEntity<Resource> getPDF(@PathVariable("id") long id ){
		Optional<Jobs> j = jobsDao.findById(id);
		if(j.isPresent()) {
			Jobs job = j.get();
			System.out.println(job.getUrlFichier());
			Resource file = fileStorageService.load(job.getUrlFichier());
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		}
		return null;
		
	}
	@GetMapping("image/{id}")
	public ResponseEntity<Resource> getImage(@PathVariable("id") long id ){
		Optional<Jobs> j = jobsDao.findById(id);
		if(j.isPresent()) {
			Jobs job = j.get();
			System.out.println(job.getUrlImage());
			Resource file = fileStorageService.load(job.getUrlImage());
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		}
		return null;
		
	}
	
	
	
}
