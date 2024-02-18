package com.narainox.reviewservice.service.impl;

import com.narainox.reviewservice.dto.CreateReviewDto;
import com.narainox.reviewservice.dto.ReviewResponse;
import com.narainox.reviewservice.dto.UpdateReviewDto;
import com.narainox.reviewservice.model.Review;
import com.narainox.reviewservice.repository.ReviewRepository;
import com.narainox.reviewservice.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl  implements ReviewService {
    @Autowired
    private ReviewRepository repository;
    @Autowired
    private ModelMapper modelMapper;



    public ReviewResponse dtoToReviewResponse(Review review)
    {
        return modelMapper.map(review,ReviewResponse.class);
    }

    @Override
    public List<ReviewResponse> getAllReviews(Long companyId) {
        return null;
    }

    @Override
    public ReviewResponse deleteReview(Long reviewId) {
        return null;
    }

    @Override
    public ReviewResponse getReview(Long reviewId) {
        return null;
    }

    @Override
    public ReviewResponse updateReview(UpdateReviewDto updateReviewDto) {
        return null;
    }

    @Override
    public ReviewResponse createReview(Long companyId, CreateReviewDto createReviewDto) {
        return null;
    }
}
