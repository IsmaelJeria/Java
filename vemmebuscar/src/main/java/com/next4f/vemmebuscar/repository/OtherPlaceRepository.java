package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.OtherPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherPlaceRepository extends JpaRepository<OtherPlace,Long> {

}
