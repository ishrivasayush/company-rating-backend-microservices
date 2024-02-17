package com.narainox.jobservice.controller;

import com.narainox.jobservice.dto.CreateJobDto;
import com.narainox.jobservice.dto.JobResponse;
import com.narainox.jobservice.dto.UpdateJobDto;
import com.narainox.jobservice.exception.JobNotFoundException;
import com.narainox.jobservice.service.JobService;
import com.narainox.jobservice.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public ResponseEntity<APIResponse> createJobHandler(@RequestBody CreateJobDto createJobDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            JobResponse job = jobService.createJob(createJobDto);
            apiResponse.setData(job);
            apiResponse.setMessage("Job is created.");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/")
    public ResponseEntity<APIResponse> updateJobHandler(@RequestBody UpdateJobDto updateJobDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            JobResponse job = jobService.updateJob(updateJobDto);
            apiResponse.setData(job);
            apiResponse.setMessage("Job is updated.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (JobNotFoundException jobNotFoundException)
        {
            throw jobNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/")
    public ResponseEntity<APIResponse> getJobsHandler()
    {
        APIResponse apiResponse=new APIResponse();
        try {
            List<JobResponse> job = jobService.getJobs();
            apiResponse.setData(job);
            apiResponse.setMessage("Jobs are found.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{jobId}")
    public ResponseEntity<APIResponse> getJobHandler(@PathVariable Long jobId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            JobResponse job = jobService.getJob(jobId);
            apiResponse.setData(job);
            apiResponse.setMessage("Job is found.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (JobNotFoundException jobNotFoundException)
        {
            throw jobNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{jobId}")
    public ResponseEntity<APIResponse> deleteJobHandler(@PathVariable Long jobId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            JobResponse job = jobService.deleteJob(jobId);
            apiResponse.setData(job);
            apiResponse.setMessage("Job is deleted.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (JobNotFoundException jobNotFoundException)
        {
            throw jobNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
