package com.karto.service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class GasStationDto {
    private Integer id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String name;
    private String addressLine;
    private String city;
    private String state;
    private String zip;
    private List<String> userEmails;
}
