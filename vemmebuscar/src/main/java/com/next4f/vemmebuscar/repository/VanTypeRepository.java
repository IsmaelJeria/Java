package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.VanEnum;
import com.next4f.vemmebuscar.domain.VanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VanTypeRepository extends JpaRepository<VanType, Long> {

    Optional<VanType> findVanTypeByType(VanEnum type);
}
