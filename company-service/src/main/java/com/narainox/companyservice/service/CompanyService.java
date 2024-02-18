package com.narainox.companyservice.service;

import com.narainox.companyservice.dto.CompanyResponse;
import com.narainox.companyservice.dto.CreateCompanyDto;
import com.narainox.companyservice.dto.UpdateCompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyResponse createCompany(CreateCompanyDto createCompanyDto);

    CompanyResponse updateCompany(UpdateCompanyDto updateCompanyDto);

    CompanyResponse deleteCompany(Long companyId);

    CompanyResponse getCompany(Long companyId);

    List<CompanyResponse> getCompanies();
}
