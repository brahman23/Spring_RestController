package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.CompanyRequest;
import com.example.spring_boot_restcontroller.dto.response.CompanyResponse;
import com.example.spring_boot_restcontroller.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class  CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAllCompany")
    public List<CompanyResponse> getAllCompany() {
        return companyService.getAllCompany();
    }

    @GetMapping("/getCompanyById/{id}")
    public CompanyResponse getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/saveCompany")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PutMapping("/updateCompany/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public CompanyResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompanyById(id);
    }
}
