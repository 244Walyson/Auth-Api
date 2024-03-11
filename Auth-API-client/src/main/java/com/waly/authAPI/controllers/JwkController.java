package com.waly.authAPI.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.interfaces.RSAPublicKey;

@Slf4j
@RestController
@RequestMapping("/ok")
public class JwkController {


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String getJwk() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String jwksJson = restTemplate.getForObject("http://localhost:8080/.well-known/jwks.json", String.class);


        log.info(new ObjectMapper().writeValueAsString(jwksJson));
        return "ok";
    }

}
