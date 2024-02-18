package com.narainox.reviewservice.repository;

import com.narainox.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
