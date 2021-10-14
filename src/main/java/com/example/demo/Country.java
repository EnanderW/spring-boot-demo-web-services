package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private String name;
    private City city;

    public Country(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
