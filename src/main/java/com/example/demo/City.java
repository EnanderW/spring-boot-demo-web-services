package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private String name;

    public City(String name) {
        this.name = name;
    }

}
