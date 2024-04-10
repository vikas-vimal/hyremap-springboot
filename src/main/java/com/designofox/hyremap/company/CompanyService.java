package com.designofox.hyremap.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findCompanyById(Long id);
    Company createCompany(Company newCompany);
    Company updateCompanyById(Long id, Company body);
    boolean deleteCompanyById(Long id);
}
