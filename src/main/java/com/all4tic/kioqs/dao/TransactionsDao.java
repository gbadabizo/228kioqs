package com.all4tic.kioqs.dao;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Lecteur;
import com.all4tic.kioqs.models.Parution;
import com.all4tic.kioqs.models.Transactions;

public interface TransactionsDao extends CrudRepository<Transactions, Long> {
		Transactions findByCodetrans(String codetrans);
		Transactions findByParutionAndLecteurAndStatusPayAndStatus(Parution parution, Lecteur lecteur, int StatusPay, int status);
		Transactions findByParutionAndLecteurAndStatusPay(Parution parution, Lecteur lecteur, int StatusPay);
		Slice<Transactions> findAllByLecteur(Lecteur lecteur, Pageable pageable);
		Transactions findByCodetransAndStatusPayAndStatus(String codetrans, int statusPay,int status);
}
