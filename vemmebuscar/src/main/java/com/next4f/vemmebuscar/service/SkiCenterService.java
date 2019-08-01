package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.SkiCenter;
import com.next4f.vemmebuscar.repository.SkiCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkiCenterService {

    @Autowired
    private SkiCenterRepository skiCenterRepository;


    public List<SkiCenter> findAll() {
        return skiCenterRepository.findAll();
    }

    public SkiCenter findById(Long id) {
        return skiCenterRepository.findById(id).get();
    }

}
