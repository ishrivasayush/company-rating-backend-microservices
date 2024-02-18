package com.narainox.reviewservice.service;

import com.narainox.reviewservice.dto.CreateReviewDto;
import com.narainox.reviewservice.dto.ReviewResponse;
import com.narainox.reviewservice.dto.UpdateReviewDto;
import com.narainox.reviewservice.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getAllReviews(Long companyId);

    ReviewResponse deleteReview(Long reviewId);

    ReviewResponse getReview(Long reviewId);

    ReviewResponse updateReview(UpdateReviewDto updateReviewDto);

    ReviewResponse createReview(Long companyId, CreateReviewDto createReviewDto);
}
