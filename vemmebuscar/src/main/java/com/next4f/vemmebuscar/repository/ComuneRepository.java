package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {

    Optional<Comune> findByName(String name);

}
