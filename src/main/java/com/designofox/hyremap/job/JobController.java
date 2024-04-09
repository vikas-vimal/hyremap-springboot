package com.designofox.hyremap.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @GetMapping("/jobs/{id}")
    public Job findOneById(@PathVariable Long id){
        System.out.println(id);
        return jobService.findById(id);
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        boolean result = jobService.createJob(job);
        if(result) {
            return "Job added successfully!";
        }
        else {
            return "Unable to save Job!";
        }
    }
}
