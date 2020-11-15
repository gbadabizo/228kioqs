package com.all4tic.kioqs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dao.JobsDao;
import com.all4tic.kioqs.dto.JobsDto;
import com.all4tic.kioqs.models.Jobs;



@Service
public class JobsServiceImpl  implements JobsService{
	@Autowired
	private JobsDao  jobsDao ;
	@Override
	public Jobs addJobs(Jobs jobs) {
		
		return jobsDao.save(jobs);
	}

	@Override
	public Jobs getJobs(long id) {
		
		return null;
	}

	@Override
	public List<Jobs> getAllJobs(int status) {
		
		return jobsDao.findAllByStatus(status);
	}
	public JobsDto JobsToJobsDto(Jobs jobs) {
		JobsDto jobsDto = new JobsDto();
		jobsDto.setAdrjob(jobs.getAdrjob());
		jobsDto.setTitre(jobs.getTitre());
		jobsDto.setDescription(jobs.getDescription());
		jobsDto.setProfil(jobs.getProfil());
		jobsDto.setPays(jobs.getPays());
		jobsDto.setTypecontrat(jobs.getTypecontrat());
		jobsDto.setLibcategorie(jobs.getJobCategorie().getLibelle());
		jobsDto.setIdjobs(jobs.getIdjobs());
		jobsDto.setDatecloture(jobs.getDatecloture());
		jobsDto.setDateannonce(jobs.getDateannonce());
		jobsDto.setUrlFichier(jobs.getUrlFichier());
		jobsDto.setUrlImage(jobs.getUrlImage());
		jobsDto.setStatus(jobs.getStatus());
		jobsDto.setSource(jobs.getSource());
		jobsDto.setValidated(jobs.getValidated());
		jobsDto.setCategorie(jobs.getJobCategorie().getIdcategorie());
		return jobsDto;
	}

}
