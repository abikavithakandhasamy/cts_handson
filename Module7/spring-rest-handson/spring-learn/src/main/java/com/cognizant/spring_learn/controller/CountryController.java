package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return countryService.getCountry(code);

    }
}


// package com.cognizant.spring_learn.controller;

// import com.cognizant.spring_learn.Country;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class CountryController {

//     @RequestMapping("/country")
//     public Country getCountryIndia() {

//         ApplicationContext context =
//                 new ClassPathXmlApplicationContext("country.xml");

//         Country country =
//                 context.getBean("country", Country.class);

//         return country;
//     }
// }