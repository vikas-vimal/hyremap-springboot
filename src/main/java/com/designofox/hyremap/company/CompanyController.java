package com.designofox.hyremap.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/v1")
public class CompanyController {
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(this.companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company found = this.companyService.findCompanyById(id);
        if(found!=null){
            return ResponseEntity.ok(found);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company body){
        Company created = this.companyService.createCompany(body);
        if(created!=null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company body){
        System.out.println("updating id "+ id);
        Company updated = this.companyService.updateCompanyById(id, body);
        if(updated!=null){
            return ResponseEntity.ok(updated);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deleted = this.companyService.deleteCompanyById(id);
        if(deleted){
            return ResponseEntity.ok("Company Deleted!");
        }
        return new ResponseEntity<>("Unable to delete company!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
