package com.designofox.hyremap.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    boolean createJob(Job job);
    Job findById(Long id);
}
