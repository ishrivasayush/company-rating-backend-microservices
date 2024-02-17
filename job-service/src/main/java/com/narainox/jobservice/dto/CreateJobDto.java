package com.narainox.jobservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateJobDto {
    private @NotBlank String title;
    private @NotBlank String description;
    private @NotBlank String minSalary;
    private @NotBlank String maxSalary;
    private @NotBlank String location;
}
