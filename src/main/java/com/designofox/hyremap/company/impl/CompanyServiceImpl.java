package com.designofox.hyremap.company.impl;

import com.designofox.hyremap.company.Company;
import com.designofox.hyremap.company.CompanyRepository;
import com.designofox.hyremap.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company createCompany(Company newCompany) {
        newCompany.setId(null);
        return companyRepository.save(newCompany);
    }

    @Override
    public Company updateCompanyById(Long id, Company body) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setId(id);
            company.setName(body.getName());
            company.setDescription(body.getDescription());
            company.setEmployeeCount(body.getEmployeeCount());
            company.setLocation(body.getLocation());
            companyRepository.save(company);
            return company;
        }
        return null;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try{
            this.companyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
