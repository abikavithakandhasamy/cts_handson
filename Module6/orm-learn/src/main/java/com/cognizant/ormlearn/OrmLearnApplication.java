package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService service;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        service = context.getBean(CountryService.class);

        test();
    }

    private static void test() {

        System.out.println("=== ALL COUNTRIES ===");

        List<Country> list = service.getAllCountries();
        list.forEach(c ->
                System.out.println(c.getCode() + " - " + c.getName())
        );

        System.out.println("=== ADD COUNTRY ===");
        service.addCountry(new Country("IN", "India"));

        System.out.println("=== AFTER ADD ===");
        service.getAllCountries().forEach(System.out::println);
    }
}