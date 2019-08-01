package com.next4f.vemmebuscar.resource;

import com.next4f.vemmebuscar.domain.Company;
import com.next4f.vemmebuscar.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/findAll")
    public List<Company> findAll(){
        return companyService.findAll();
    }

}
