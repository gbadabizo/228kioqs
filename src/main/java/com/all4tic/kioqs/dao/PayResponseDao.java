package com.all4tic.kioqs.dao;

import org.springframework.data.repository.CrudRepository;

import com.all4tic.kioqs.models.Payresponse;
import com.all4tic.kioqs.models.Transactions;

public interface PayResponseDao extends CrudRepository<Payresponse, Long> {
		Payresponse findByTransactions(Transactions t);
}
