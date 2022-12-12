package com.example.spring_boot_restcontroller.converter.company;

import com.example.spring_boot_restcontroller.dto.request.CompanyRequest;
import com.example.spring_boot_restcontroller.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverterRequest {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) return null;
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        if (companyRequest.getCompanyName() == null ) {

        } else {
            company.setCompanyName(companyRequest.getCompanyName());
        }
        if (companyRequest.getLocatedCountry() == null ) {

        } else {
            company.setLocatedCountry(companyRequest.getLocatedCountry());
        }
    }
}
