package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.Comune;
import com.next4f.vemmebuscar.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public List<Comune> findAll() {
        return comuneRepository.findAll();
    }

    public Comune findByName(String name) {
        Optional<Comune> comune = comuneRepository.findByName(name.toUpperCase());

        if (!comune.isPresent())
            throw new RuntimeException("Comuna no disponible");
        else
            return comune.get();
    }

    public Comune findById(Long id) {
        Optional<Comune> comune = comuneRepository.findById(id);

        if (!comune.isPresent())
            throw new RuntimeException("Comuna no disponible");

        return comune.get();
    }

    public void countryGuardClause(String country) {
        if (!country.toUpperCase().equals("CHILE"))
            throw new RuntimeException("País no disponible");
    }

    public void regionGuarClause(String region) {
        if (!region.toUpperCase().equals("REGIÓN METROPOLITANA") && !region.toUpperCase().equals("SANTIAGO"))
            throw new RuntimeException("La unica region disponible es la Región Metropolitana");
    }

}
