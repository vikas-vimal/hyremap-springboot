package com.designofox.hyremap.job.impl;

import com.designofox.hyremap.job.Job;
import com.designofox.hyremap.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
