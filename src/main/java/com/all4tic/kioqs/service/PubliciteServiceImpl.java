package com.all4tic.kioqs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dao.PubliciteDao;
import com.all4tic.kioqs.models.Publicite;
@Service
public class PubliciteServiceImpl implements PubliciteService{
	@Autowired
	private PubliciteDao publiciteDao ;

	@Override
	public Publicite addPublicite(Publicite pub) {
		
		return publiciteDao.save(pub);
	}

	@Override
	public List<Publicite> listPublicite() {
		
		return (List<Publicite>) publiciteDao.findAll();
	}

}
