package com.example.spring_boot_restcontroller.service;

import com.example.spring_boot_restcontroller.dto.request.CompanyRequest;
import com.example.spring_boot_restcontroller.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getAllCompany();

    CompanyResponse getCompanyById(Long id);

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse deleteCompanyById(Long id);
}
