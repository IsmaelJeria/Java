package com.next4f.vemmebuscar.resource;

import com.next4f.vemmebuscar.domain.SkiCenter;
import com.next4f.vemmebuscar.service.SkiCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SkiCenterResource {

    @Autowired
    private SkiCenterService skiCenterService;

    @GetMapping("/skiCenter/findAll")
    public List<SkiCenter> findAll() {
        return skiCenterService.findAll();
    }

}
