package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.ArrivalEnum;
import com.next4f.vemmebuscar.domain.VanEnum;
import com.next4f.vemmebuscar.domain.VanType;
import com.next4f.vemmebuscar.repository.VanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VanTypeService {

    @Autowired
    private VanTypeRepository vanTypeRepository;

    public VanType findByType(VanEnum type) {
        Optional<VanType> vanType = vanTypeRepository.findVanTypeByType(type);

        if (!vanType.isPresent())
            throw new RuntimeException("vanType is not present");

        return vanType.get();
    }


    public VanEnum findVanEnum(String name) {

        VanEnum vanEnum = VanEnum.valueOf(name);

        if (vanEnum == null)
            throw new RuntimeException("Arrival value must be 'EXCLUSIVE' or 'SHARED' ");

        return vanEnum;
    }

}
