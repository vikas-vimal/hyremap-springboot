package com.designofox.hyremap.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job createJob(Job job);
    Job findById(Long id);
    boolean deleteJobById(Long id);
    Job updateJobById(Long id, Job body);
}
