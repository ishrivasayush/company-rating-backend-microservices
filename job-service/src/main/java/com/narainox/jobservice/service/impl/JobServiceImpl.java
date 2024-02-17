package com.narainox.jobservice.service.impl;

import com.narainox.jobservice.dto.CreateJobDto;
import com.narainox.jobservice.dto.JobResponse;
import com.narainox.jobservice.dto.UpdateJobDto;
import com.narainox.jobservice.exception.JobNotFoundException;
import com.narainox.jobservice.model.Job;
import com.narainox.jobservice.repository.JobRepository;
import com.narainox.jobservice.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JobResponse createJob(CreateJobDto createJobDto) {
        Job job = modelMapper.map(createJobDto, Job.class);
        Job save = jobRepository.save(job);
        return modelMapper.map(save,JobResponse.class);
    }

    @Override
    public JobResponse updateJob(UpdateJobDto updateJobDto) {
        Job job = jobRepository.findById(updateJobDto.getId())
                .orElseThrow(() -> new JobNotFoundException("Job", "jobId", updateJobDto.getId()));
        job.setDescription(updateJobDto.getDescription());
        job.setLocation(updateJobDto.getLocation());
        job.setTitle(updateJobDto.getTitle());
        job.setMaxSalary(updateJobDto.getMaxSalary());
        job.setMinSalary(updateJobDto.getMinSalary());
        Job save = jobRepository.save(job);
        return modelMapper.map(job,JobResponse.class);
    }

    @Override
    public List<JobResponse> getJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobResponseStream = jobs.stream().map(this::jobToJobResponse).collect(Collectors.toList());
        return jobResponseStream;
    }

    @Override
    public JobResponse getJob(Long jobId) {
        Job job = jobRepository
                .findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job", "jobId", jobId));
        return modelMapper.map(job,JobResponse.class);
    }

    @Override
    public JobResponse deleteJob(Long jobId) {
        Job job = jobRepository
                .findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job", "jobId", jobId));
        jobRepository.delete(job);
        return modelMapper.map(job,JobResponse.class);
    }

    public JobResponse jobToJobResponse(Job job)
    {
        return modelMapper.map(job,JobResponse.class);
    }

}
