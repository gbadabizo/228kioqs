package com.all4tic.kioqs.RestControllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.all4tic.kioqs.dto.JobsDto;
import com.all4tic.kioqs.models.Jobs;
import com.all4tic.kioqs.models.News;
import com.all4tic.kioqs.service.FileStorageService;
import com.all4tic.kioqs.service.NewsService;
import com.all4tic.kioqs.utilities.Utility;

@RestController
@RequestMapping("/api/news/")
@CrossOrigin(origins = "*")
public class NewsRestController {
	@Autowired
	private NewsService newsService ;
	@Autowired
	private FileStorageService fileStorageService ;

	@GetMapping("all/{offset}/{limit}")
	public  ResponseEntity<Page<News>> actionListNews(@PathVariable int offset , @PathVariable int limit){
		return new ResponseEntity<>(newsService.listNewsByPage(offset, limit), HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<News> actionAddJobs(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam(name="imageFile1",required=false) MultipartFile imageFile1,
			@RequestParam(name="imageFile2",required=false) MultipartFile imageFile2,
			@RequestParam(name="imageFile3", required=false) MultipartFile imageFile3,
			@RequestParam(name="imageFile4", required=false) MultipartFile imageFile4,
			@RequestParam(name="pdfFile", required=false) MultipartFile pdfFile,
			@RequestParam("titre") String titre,
			 @RequestParam("contenu") String  contenu,
			 @RequestParam("datePublication") String datePublication,
			 @RequestParam("source") String source,
			 @RequestParam(name="urlvideo", required=false) String urlvideo
			){
		News news = new News();
		String code = ""+Math.abs(Utility.generateRandomDigits(8));
		news.setTitre(titre);
		news.setCode(code);
		news.setContenu(contenu);
		news.setUrlSource(source);
		news.setUrlvideo(urlvideo);
		news.setDatePublication(LocalDate.parse(datePublication));
		
		
		if(imageFile!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"."+extension.trim();
		    Path root=  Paths.get("uploads/img/news/"+news.getCode().trim());
		    news.setUrlImage(root+"/"+newFilename);
		}
		if(imageFile1!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"_1."+extension.trim();
		    Path root=  Paths.get("uploads/img/news/"+news.getCode().trim());
		    news.setUrlImage1(root+"/"+newFilename);
		}
		if(imageFile2!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"_2."+extension.trim();
		    Path root=  Paths.get("uploads/img/news/"+news.getCode().trim());
		    news.setUrlImage2(root+"/"+newFilename);
		}
		if(imageFile3!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"_3."+extension.trim();
		    Path root=  Paths.get("uploads/img/news/"+news.getCode().trim());
		    news.setUrlImage3(root+"/"+newFilename);
		}
		if(imageFile4!=null) {
			String originFileName= imageFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename = code+"_4."+extension.trim();
		    Path root=  Paths.get("uploads/img/news/"+news.getCode().trim());
		    news.setUrlImage4(root+"/"+newFilename);
		}
		System.out.print(pdfFile);
		if(pdfFile!=null) {
			String originFileName= pdfFile.getOriginalFilename();
		    String extension =  fileStorageService.getExtensionByStringHandling(originFileName).get();
		    String newFilename =code+"."+extension.trim();
		    Path root=  Paths.get("uploads/pdf/news/"+news.getCode().trim());
		    news.setUrlFichier(root+"/"+newFilename);
		}
		News newNews = newsService.add(news);
		if(newNews!=null) {
			fileStorageService.save(imageFile, newNews, 2, newNews.getCode());
			if(imageFile1!=null)
			fileStorageService.save(imageFile1, newNews, 2, newNews.getCode()+"_1");
			if(imageFile2!=null)
			fileStorageService.save(imageFile2, newNews, 2, newNews.getCode()+"_2");
			if(imageFile3!=null)
			fileStorageService.save(imageFile3, newNews, 2, newNews.getCode()+"_3");
			if(imageFile4!=null)
			fileStorageService.save(imageFile4, newNews, 2, newNews.getCode()+"_4");
			if(pdfFile!=null)
			  fileStorageService.save(pdfFile, newNews, 1, newNews.getCode());
		}
		return new ResponseEntity<>(newNews, HttpStatus.OK);
	}
}
