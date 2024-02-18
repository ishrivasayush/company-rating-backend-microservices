package com.narainox.reviewservice.controller;

import com.narainox.reviewservice.dto.CreateReviewDto;
import com.narainox.reviewservice.dto.ReviewResponse;
import com.narainox.reviewservice.dto.UpdateReviewDto;
import com.narainox.reviewservice.exception.ReviewNotFoundException;
import com.narainox.reviewservice.service.ReviewService;
import com.narainox.reviewservice.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<APIResponse<List<ReviewResponse>>> getReviewsHandler(@RequestParam Long companyId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            List<ReviewResponse> reviews = reviewService.getAllReviews(companyId);
            apiResponse.setData(reviews);
            apiResponse.setMessage("Review is found");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse<ReviewResponse>> createReviewHandler(@RequestParam Long companyId,
                                                                           @RequestBody CreateReviewDto createReviewDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ReviewResponse review = reviewService.createReview(companyId, createReviewDto);
            apiResponse.setData(review);
            apiResponse.setMessage("Review is created");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<APIResponse> updateReviewHandler(@RequestBody UpdateReviewDto updateReviewDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ReviewResponse review = reviewService.updateReview(updateReviewDto);
            apiResponse.setData(review);
            apiResponse.setMessage("Review is updated.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (ReviewNotFoundException reviewNotFoundException)
        {
            throw reviewNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{reviewId}")
    public ResponseEntity<APIResponse> getReviewHandler(@PathVariable Long reviewId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ReviewResponse review = reviewService.getReview(reviewId);
            apiResponse.setData(review);
            apiResponse.setMessage("Review is found.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (ReviewNotFoundException reviewNotFoundException)
        {
            throw reviewNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<APIResponse> deleteReviewHandler(@PathVariable Long reviewId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ReviewResponse review = reviewService.deleteReview(reviewId);
            apiResponse.setData(review);
            apiResponse.setMessage("Review is deleted.");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (ReviewNotFoundException reviewNotFoundException)
        {
            throw reviewNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
