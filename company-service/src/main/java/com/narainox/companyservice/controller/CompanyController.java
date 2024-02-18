package com.narainox.companyservice.controller;

import com.narainox.companyservice.dto.CompanyResponse;
import com.narainox.companyservice.dto.CreateCompanyDto;
import com.narainox.companyservice.dto.UpdateCompanyDto;
import com.narainox.companyservice.exception.CompanyNotFoundException;
import com.narainox.companyservice.service.CompanyService;
import com.narainox.companyservice.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<APIResponse> createJobHandler(@RequestBody CreateCompanyDto createCompanyDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CompanyResponse companyResponse=companyService.createCompany(createCompanyDto);
            apiResponse.setData(companyResponse);
            apiResponse.setMessage("Job is created.");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/")
    public ResponseEntity<APIResponse> updateJobHandler(@RequestBody UpdateCompanyDto updateCompanyDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CompanyResponse company = companyService.updateCompany(updateCompanyDto);
            apiResponse.setData(company);
            apiResponse.setMessage("Job is updated.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (CompanyNotFoundException companyNotFoundException)
        {
            throw companyNotFoundException;
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
            List<CompanyResponse> companies = companyService.getCompanies();
            apiResponse.setData(companies);
            apiResponse.setMessage("Jobs are found.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<APIResponse> getJobHandler(@PathVariable Long companyId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CompanyResponse company = companyService.getCompany(companyId);
            apiResponse.setData(company);
            apiResponse.setMessage("Job is found.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (CompanyNotFoundException companyNotFoundException)
        {
            throw companyNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{companyId}")
    public ResponseEntity<APIResponse> deleteJobHandler(@PathVariable Long companyId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CompanyResponse company = companyService.deleteCompany(companyId);
            apiResponse.setData(company);
            apiResponse.setMessage("Job is deleted.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (CompanyNotFoundException companyNotFoundException)
        {
            throw companyNotFoundException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
