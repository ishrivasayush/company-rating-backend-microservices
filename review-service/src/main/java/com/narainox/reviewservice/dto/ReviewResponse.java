package com.narainox.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponse {
    private Long id;
    private String title;
    private String description;
    private Double rating;
}
