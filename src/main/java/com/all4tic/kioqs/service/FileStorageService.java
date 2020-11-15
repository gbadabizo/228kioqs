package com.all4tic.kioqs.service;


import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.kioqs.models.Jobs;
import com.all4tic.kioqs.models.News;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Publicite;

public interface FileStorageService {
	  public void init();

	  public void save(MultipartFile file,  Parution parution, int type);
	  public void save(MultipartFile file,  Jobs jobs, int type);
	  public void save(MultipartFile file,  News news, int type, String filename);
	  public void save(MultipartFile file, Publicite publicite);

	  public Resource  load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
	  public Optional<String> getExtensionByStringHandling(String filename);

}
