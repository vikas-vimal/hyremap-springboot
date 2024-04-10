package com.designofox.hyremap.company;

import com.designofox.hyremap.job.Job;
import com.designofox.hyremap.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int employeeCount;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company(){}

    public Company(Long id, String name, String description, int employeeCount, String location, List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.employeeCount = employeeCount;
        this.location = location;
        this.jobs = jobs;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
