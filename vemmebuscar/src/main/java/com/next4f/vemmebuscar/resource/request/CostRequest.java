package com.next4f.vemmebuscar.resource.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CostRequest {
    private Long skiCenterId;
    private Long destinationId;
    private int adults;
    private int babies;
    private int children;
    private String comuneDestination;
    private String countryDestination;
    private String regionDestination;
    private String arrival;
    private String trip;
}
