package com.next4f.vemmebuscar.resource;

import com.next4f.vemmebuscar.domain.Comune;
import com.next4f.vemmebuscar.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ComuneResource {

    @Autowired
    private ComuneService comuneService;

    @GetMapping("/comune/findAll")
    public List<Comune> findAll() {
        return comuneService.findAll();
    }

}
