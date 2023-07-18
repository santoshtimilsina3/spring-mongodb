package com.santosh.springmongodb.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Address {

    private String address1;
    private String address2;
    private String city;

}
