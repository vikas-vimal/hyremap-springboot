package com.designofox.hyremap.review.impl;

import com.designofox.hyremap.company.Company;
import com.designofox.hyremap.company.CompanyService;
import com.designofox.hyremap.review.Review;
import com.designofox.hyremap.review.ReviewRepository;
import com.designofox.hyremap.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviewsList() {
        return this.reviewRepository.findAll();
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long cid) {
        return this.reviewRepository.findByCompanyId(cid);
    }

    @Override
    public Review getReviewById(Long id) {
        return this.reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review addReview(Long cid, Review body) {
        Company companyExists = this.companyService.findCompanyById(cid);
        if(companyExists == null) return null;
        body.setId(null);
        body.setCompany(companyExists);
        return this.reviewRepository.save(body);
    }

    @Override
    public Review updateReviewById(Long id, Review body) {
        Optional<Review> foundReview = this.reviewRepository.findById(id);
        if(foundReview.isPresent()){
            Review review = foundReview.get();
            review.setId(id);
            review.setTitle(body.getTitle());
            review.setDescription(body.getDescription());
            review.setName(body.getName());
            review.setRating(body.getRating());
            this.reviewRepository.save(review);
            return review;
        }
        return null;
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            this.reviewRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
