package com.all4tic.kioqs.service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.kioqs.dao.ParutionDao;
import com.all4tic.kioqs.models.Agence;
import com.all4tic.kioqs.models.Parution;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	  private final Path root = Paths.get("uploads");
	  private ParutionDao parutionDao ;

	  @Override
	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }

	  @Override
	  public void save(MultipartFile file, Parution parution, int type) {
		  // 1 = pdf file, 2 = image
		  if(parution !=null) {
			  Agence agence = parution.getAgence();
			  Path agenceFolder=null;
	    try {
	    	if(type==1) {
	    		agenceFolder = Paths.get("uploads/pdf/"+agence.getCode().trim());
	    	}
	    		else {
	    		 agenceFolder = Paths.get("uploads/img/"+agence.getCode().trim());
	    		}
	    	
	    	if(!Files.exists(agenceFolder)) {
	    		try {
	                Files.createDirectories(agenceFolder);
	            } catch (IOException e) {
	                //fail to create directory
	                e.printStackTrace();
	            }
	    	}
	    String originFileName= file.getOriginalFilename();
	    String extension = getExtensionByStringHandling(originFileName).get();
	    String newFilename = parution.getCode()+"."+extension.trim();
	    Path newPath= Paths.get(agenceFolder+"/"+newFilename);
	    if(Files.notExists(newPath)) {
	        Files.copy(file.getInputStream(), agenceFolder.resolve(newFilename));
	    }else {
	    	boolean result = Files.deleteIfExists(newPath);
	    	System.out.println("ecrasement de fichier : "+result);
	    	if(result)
	    	  Files.copy(file.getInputStream(), agenceFolder.resolve(newFilename));
	    }
	     
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
		  }
	  }
	 
		
	
	  public Optional<String> getExtensionByStringHandling(String filename) {
		    return Optional.ofNullable(filename)
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
		}
	  @Override
	  public Resource load(String filename) {
	    try {
	      //Path file = root.resolve(filename);
	    	Path file = Paths.get(filename);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	  @Override
	  public void deleteAll() {
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  @Override
	  public Stream<Path> loadAll() {
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }

}
