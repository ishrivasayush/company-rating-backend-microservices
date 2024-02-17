package com.narainox.jobservice.service;

import com.narainox.jobservice.dto.CreateJobDto;
import com.narainox.jobservice.dto.JobResponse;
import com.narainox.jobservice.dto.UpdateJobDto;

import java.util.List;

public interface JobService {
    JobResponse createJob(CreateJobDto createJobDto);

    JobResponse updateJob(UpdateJobDto updateJobDto);

    List<JobResponse> getJobs();

    JobResponse getJob(Long jobId);

    JobResponse deleteJob(Long jobId);
}
