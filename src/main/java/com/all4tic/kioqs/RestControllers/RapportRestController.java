package com.all4tic.kioqs.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.kioqs.dao.VtransactionsDao;
import com.all4tic.kioqs.models.vtransactions;

@RestController
@RequestMapping("/api/rapport/")
@CrossOrigin(origins = "*")
public class RapportRestController {
	@Autowired
	private VtransactionsDao vtransactionsDao ;
	@GetMapping("transactions/{offset}/{limit}")
	public ResponseEntity<Page<vtransactions>> getAllTransactions(@PathVariable("offset")int offset,
			@PathVariable("limit") int limit){
		Pageable sortedBydateop = PageRequest.of(offset,limit, Sort.by("dateop").descending());
		Page<vtransactions> slicetransactions = vtransactionsDao.findAll(sortedBydateop);
		return new ResponseEntity<>(slicetransactions, HttpStatus.OK);
	}
	@GetMapping("transactions/all")
	public ResponseEntity<List<vtransactions>> getAllTransactions(){
		List<vtransactions> transactions = vtransactionsDao.findByOrderByDateopDesc();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

}
