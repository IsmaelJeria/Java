package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findFirstById (Long companyId);
}
