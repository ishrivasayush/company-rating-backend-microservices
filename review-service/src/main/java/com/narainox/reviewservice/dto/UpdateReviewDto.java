package com.narainox.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewDto {
        private Long id;
        private String title;
        private String description;
        private Double rating;
}
