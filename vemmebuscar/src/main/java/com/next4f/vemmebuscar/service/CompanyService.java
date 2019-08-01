package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.Company;
import com.next4f.vemmebuscar.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findFirstById(Long companyId) {

        if(companyId==null)
            return new Company();

        Optional<Company> companyOptional = companyRepository.findFirstById(companyId);
        if (!companyOptional.isPresent())
            return new Company();
           // throw new RuntimeException("Company with id" + companyId + "is not present");

        return companyOptional.get();
    }


}
