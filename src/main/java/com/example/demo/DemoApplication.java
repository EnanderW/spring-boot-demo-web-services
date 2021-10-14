package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    /*

    * Man skall kunna skapa/lägga till produkter
    * Man skall kunna visa upp/lista upp alla/specifika produkter
    * Man skall kunna ta bort produkter
    * Man skall kunna ändra produkter (e.g ändra pris)

     */

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
