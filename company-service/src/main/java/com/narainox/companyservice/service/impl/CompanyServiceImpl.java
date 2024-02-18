package com.narainox.companyservice.service.impl;

import com.narainox.companyservice.dto.CompanyResponse;
import com.narainox.companyservice.dto.CreateCompanyDto;
import com.narainox.companyservice.dto.UpdateCompanyDto;
import com.narainox.companyservice.exception.CompanyNotFoundException;
import com.narainox.companyservice.model.Company;
import com.narainox.companyservice.repository.CompanyRepository;
import com.narainox.companyservice.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompanyResponse createCompany(CreateCompanyDto createCompanyDto) {
        Company company = companyRepository.save(modelMapper.map(createCompanyDto, Company.class));
        return dtoToCompanyResponse(company);
    }

    @Override
    public CompanyResponse updateCompany(UpdateCompanyDto updateCompanyDto) {
        Company company = companyRepository
                .findById(updateCompanyDto.getId())
                .orElseThrow(() -> new CompanyNotFoundException("Company", "CompanyId", updateCompanyDto.getId()));
        company.setName(updateCompanyDto.getName());
        company.setDescription(updateCompanyDto.getDescription());
        companyRepository.save(company);
        return dtoToCompanyResponse(company);
    }

    @Override
    public CompanyResponse deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException("Company", "CompanyId", companyId));
        companyRepository.delete(company);
        return dtoToCompanyResponse(company);
    }

    @Override
    public CompanyResponse getCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException("Company", "CompanyId", companyId));
        return dtoToCompanyResponse(company);
    }

    @Override
    public List<CompanyResponse> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyResponse> companyResponses = companies.stream().map(this::dtoToCompanyResponse).collect(Collectors.toList());
        return companyResponses;
    }
    public CompanyResponse dtoToCompanyResponse(Company company)
    {
        return modelMapper.map(company,CompanyResponse.class);
    }
}
