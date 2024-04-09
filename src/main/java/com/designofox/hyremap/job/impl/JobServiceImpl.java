package com.designofox.hyremap.job.impl;

import com.designofox.hyremap.job.Job;
import com.designofox.hyremap.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobsDatabase = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobsDatabase;
    }

    @Override
    public boolean createJob(Job job) {
        job.setId(nextId++);
        jobsDatabase.add(job);
        return true;
    }

    @Override
    public Job findById(Long id) {
        for(Job job: jobsDatabase){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public Job deleteJobById(Long id) {
        Iterator<Job> iterator = jobsDatabase.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return job;
            }
        }
        return null;
    }

    @Override
    public Job updateJobById(Long id, Job body) {
        Job foundJob = null;
        for(Job job: jobsDatabase){
            if(job.getId().equals(id)){
                job.setTitle(body.getTitle());
                job.setDescription(body.getDescription());
                job.setMinSalary(body.getMinSalary());
                job.setMaxSalary(body.getMaxSalary());
                job.setLocation(body.getLocation());
                foundJob = job;
            }
        }
        return foundJob;
    }

    public Job deleteJobById_bak(Long id) {
        Job foundJob = null;
        for(Job job: jobsDatabase){
            if(job.getId().equals(id)){
                foundJob = job;
                jobsDatabase.remove(job);
            }
        }
        return foundJob;
    }

}
