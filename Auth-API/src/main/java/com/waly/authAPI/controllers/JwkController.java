package com.waly.authAPI.controllers;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.waly.authAPI.config.AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.interfaces.RSAPublicKey;
import java.util.Map;

@RestController
public class JwkController {

    @Autowired
    private AuthorizationServerConfig authorizationServer;

    @GetMapping(value = "/.well-known/jwks.json")
    public Map<String, Object> getJwks() throws JOSEException {
        RSAPublicKey publicKey = authorizationServer.getRsaPublicKey();

        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .keyUse(KeyUse.SIGNATURE)
                .build();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return jwkSet.toJSONObject();
    }

}
