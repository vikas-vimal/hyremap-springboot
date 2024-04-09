package com.designofox.hyremap.job.impl;

import com.designofox.hyremap.job.Job;
import com.designofox.hyremap.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobsDatabase = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobsDatabase;
    }

    @Override
    public boolean createJob(Job job) {
        jobsDatabase.add(job);
        return true;
    }
}
