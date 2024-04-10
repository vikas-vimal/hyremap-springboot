package com.designofox.hyremap.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsList();
    List<Review> getAllReviewsByCompanyId(Long cid);
    Review getReviewById(Long id);
    Review addReview(Long companyId, Review body);
    Review updateReviewById(Long id, Review body);
    boolean deleteReviewById(Long id);
}
