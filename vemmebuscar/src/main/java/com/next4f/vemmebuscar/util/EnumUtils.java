package com.next4f.vemmebuscar.util;

import com.next4f.vemmebuscar.domain.ArrivalEnum;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EnumUtils {

    public static boolean isPresent(Enum enumArray[], String name) {
        for (Enum element: enumArray ) {
            if(element.name().equals(name))
                return true;
        }
        return false;
    }

}
