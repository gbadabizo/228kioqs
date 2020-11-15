package com.all4tic.kioqs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.all4tic.kioqs.models.TransactionsSuscribe;
@Repository
public interface TransactionsSuscribeDao extends CrudRepository<TransactionsSuscribe, Long> {
	TransactionsSuscribe findByCodetrans(String codetrans);
	TransactionsSuscribe findByCodetransAndStatusPayAndStatus(String codetrans, int statusPay,int status);
}
