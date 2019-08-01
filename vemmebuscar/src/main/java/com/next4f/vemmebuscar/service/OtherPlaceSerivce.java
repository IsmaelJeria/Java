package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.OtherPlace;
import com.next4f.vemmebuscar.repository.OtherPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherPlaceSerivce {

    @Autowired
    private OtherPlaceRepository otherPlaceRepository;

    public List<OtherPlace> findAll() {
        return otherPlaceRepository.findAll();
    }

    public OtherPlace findById(Long id){
        return otherPlaceRepository.findById(id).get();
    }

}
