package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private Map<String, Country> countries = new HashMap<>();
    private Map<String, City> cities = new HashMap<>();

    public TestController() {
        City city = new City("Stockholm");
        countries.put("Sverige", new Country("Sverige", city));
        cities.put("Stockholm", city);

        city = new City("Oslo");
        countries.put("Norge", new Country("Norge", city));
        cities.put("Oslo", city);
    }

    @GetMapping("/countries")
    public List<CountryDTO> getCountries() {
       return countries.values()
               .stream()
               .map(country -> new CountryDTO(country.getName(), "/city/" + country.getCity().getName()))
               .collect(Collectors.toList());
    }

    @GetMapping("/city/{cityName}")
    public City getCity(@PathVariable("cityName") String cityName) {
        for (City city : cities.values()) {
            if (city.getName().equalsIgnoreCase(cityName))
                return city;
        }

        return null;
    }

    @GetMapping("/cities")
    public Collection<City> getCities() {
        return cities.values();
    }

    @Getter
    @Setter
    public static final class CountryDTO {
        private String name;
        private String cityLink;

        public CountryDTO(String name, String cityLink) {
            this.name = name;
            this.cityLink = cityLink;
        }

    }


}
