package com.next4f.vemmebuscar.repository;
import com.next4f.vemmebuscar.domain.SkiCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkiCenterRepository extends JpaRepository<SkiCenter, Long> {
}
