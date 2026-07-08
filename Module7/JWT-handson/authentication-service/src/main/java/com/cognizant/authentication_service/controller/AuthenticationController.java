package com.cognizant.authentication_service.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader(value = "Authorization", required = false)
            String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        Map<String, String> map = new HashMap<>();

        String token = "";

        if (authHeader != null) {

            String user = getUser(authHeader);

            LOGGER.debug("User : {}", user);

            token = generateJwt(user);
        }

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("Inside getUser()");

        String encodedCredentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String decodedString = new String(decodedBytes);

        LOGGER.debug("Decoded String : {}", decodedString);

        String user = decodedString.substring(0,
                decodedString.indexOf(":"));

        LOGGER.debug("Username : {}", user);

        return user;
    }

    private String generateJwt(String user) {

        LOGGER.debug("Inside generateJwt()");

        JwtBuilder builder = Jwts.builder();

        builder.setSubject(user);

        builder.setIssuedAt(new Date());

        builder.setExpiration(
                new Date(new Date().getTime() + 1200000));

        builder.signWith(SignatureAlgorithm.HS256,
                "secretkey");

        String token = builder.compact();

        LOGGER.debug("Generated Token : {}", token);

        return token;
    }
}