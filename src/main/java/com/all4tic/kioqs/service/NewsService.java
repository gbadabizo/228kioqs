package com.all4tic.kioqs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.all4tic.kioqs.models.News;

public interface NewsService {
	News add(News news);
	List<News> listNews(int offset, int limit);
	Page<News> listNewsByPage(int offset, int limit);
}
