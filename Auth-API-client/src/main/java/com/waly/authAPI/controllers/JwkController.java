package com.waly.authAPI.controllers;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.interfaces.RSAPublicKey;

@RestController
public class JwkController {


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/ok")
    public String getJwk() {
        return "ok";
    }

}
