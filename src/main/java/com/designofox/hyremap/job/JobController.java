package com.designofox.hyremap.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job/v1")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findOneById(@PathVariable Long id){
        Job foundJob = jobService.findById(id);
        if(foundJob != null){
            return new ResponseEntity<>(foundJob, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        boolean result = jobService.createJob(job);
        if(result) {
            return new ResponseEntity<>("Job added successfully!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Unable to save Job!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Job> deleteJobById(@PathVariable Long id){
        Job deletedJob = jobService.deleteJobById(id);
        if(deletedJob != null){
            return ResponseEntity.ok(deletedJob);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJobById(@PathVariable Long id, @RequestBody Job body){
        Job updatedJob = jobService.updateJobById(id, body);
        if(updatedJob!=null){
            return new ResponseEntity<>(updatedJob, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
