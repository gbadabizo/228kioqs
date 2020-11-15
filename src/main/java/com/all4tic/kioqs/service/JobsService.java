package com.all4tic.kioqs.service;

import java.util.List;

import com.all4tic.kioqs.models.Jobs;



public interface JobsService {
 public	Jobs addJobs(Jobs jobs);
 public Jobs getJobs(long id) ;
 public List<Jobs> getAllJobs(int status);

}
