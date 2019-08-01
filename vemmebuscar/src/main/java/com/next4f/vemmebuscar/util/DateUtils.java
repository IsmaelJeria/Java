package com.next4f.vemmebuscar.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static void pastYearAndMonthAnHourDateValidation(LocalDateTime localDateTime) {
        if (localDateTime.isBefore(LocalDateTime.now().plusDays(1)))
            throw new RuntimeException("the date and time can not be from the past and you must book 1 day in advance");
    }

    public static LocalDateTime stringToLocalDateTime(String localDateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (localDateTime.substring(12, 13).equals(":")) {
            localDateTime = localDateTime.replace(" ", " 0");
        }

        return LocalDateTime.parse(localDateTime, formatter);
    }


}
