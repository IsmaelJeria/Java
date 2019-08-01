package com.next4f.vemmebuscar.resource;

import com.next4f.vemmebuscar.domain.OtherPlace;
import com.next4f.vemmebuscar.service.OtherPlaceSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OtherPlaceResource {

    @Autowired
    private OtherPlaceSerivce otherPlaceSerivce;

    @GetMapping("/otherDestination/findAll")
    public List<OtherPlace> findALL() {
        return otherPlaceSerivce.findAll();
    }

}
