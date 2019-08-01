package com.next4f.vemmebuscar.resource.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CustomerRequest {
    private String customerName;
    private String customerEmail;
    private Long destinationId;
    private String passport;
    private String phoneNumber;
    private String countryDestination;
    private String comuneDestination;
    private String regionDestination;
    private String fullAddress;
    private String trip;
    private int adults;
    private int babies;
    private int children;
    private String arrival;
    private String vanType; //no se usa el end-point indica que es de tipo van exclusiva
    private String flightNumber;
    private Long companyId;
    private String companyName;
    private Boolean wheelchair;
    private Boolean babychair;
    private String additionalServices;
    private String specialOrder;
    private Long skiCenterId;
   //   @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
   //   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
      private String arrivalDateTime;

  //  private String arrivalDateTime;

  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  //  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String departureDateTime;

    private Boolean childCarSeat;

    /*LAS FECHAS DE ARRIBA REEMPLAZAN ESTOS 2 ATRIBUTOS, PERO SE DEJAN POR QUE CON ESTOS SE PINTA EL CORREO!!! */
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String transferLocalDateTime;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String returnLocalDateTime;


}

