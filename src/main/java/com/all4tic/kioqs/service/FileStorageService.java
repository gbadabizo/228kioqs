package com.all4tic.kioqs.service;


import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.all4tic.kioqs.models.Parution;

public interface FileStorageService {
	  public void init();

	  public void save(MultipartFile file,  Parution parution, int type);

	  public Resource  load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
	  public Optional<String> getExtensionByStringHandling(String filename);

}
