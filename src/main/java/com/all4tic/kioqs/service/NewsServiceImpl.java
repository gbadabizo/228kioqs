package com.all4tic.kioqs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dao.NewsDao;
import com.all4tic.kioqs.models.News;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;
	@Override
	public News add(News news) {	
		return newsDao.save(news);
	}
	@Override
	public List<News> listNews(int offset, int limit) {
		Pageable sortedByDatePublication = PageRequest.of(offset,limit, Sort.by("datePublication").descending());
		Slice<News> sliceNews = newsDao.findAllByPublished(0, sortedByDatePublication);
		List<News> listNews = sliceNews.getContent();
		return listNews;
	}
	@Override
	public Page<News> listNewsByPage(int offset, int limit) {
		Pageable sortedByDatePublication = PageRequest.of(offset,limit, Sort.by("datePublication").descending());
		Page<News> listNews = newsDao.findAllByStatus(1, sortedByDatePublication);
		return listNews;
	}

}
