package com.all4tic.kioqs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Categorie;

public interface CategorieDao extends CrudRepository<Categorie, Integer> {
		List<Categorie> findAllByStatus(int status);
}
