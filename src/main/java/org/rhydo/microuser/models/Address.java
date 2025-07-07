package org.rhydo.microuser.models;

import lombok.Data;

@Data
public class Address {

    private String id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
