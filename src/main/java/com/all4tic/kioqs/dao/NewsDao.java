package com.all4tic.kioqs.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.kioqs.models.News;

@Repository
public interface NewsDao extends CrudRepository<News, Long> {
	Slice<News>findAllByPublished(int published, Pageable pageable);
	Page<News>findAllByStatus(int status, Pageable pageable);
}
