package twgl.com.helloAws.application.rest.controllers;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twgl.com.helloAws.domain.dtos.security.AccountCredentialsDTO;
import twgl.com.helloAws.domain.services.AuthServices;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    
    @Autowired
    AuthServices authServices;

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody AccountCredentialsDTO accountCredentials) {
        
        if (accountCredentials == null) return ResponseEntity.badRequest().body("Cannot authenticate with empty fields");

        var token = authServices.signin(accountCredentials);

        if (token == null) return ResponseEntity.badRequest().body("Invalid credentials");
        return token;
    }

/*     @GetMapping("/encodepassword")
    public String encodePassword(@RequestParam String password) {
				
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        return encodedPassword;
    } */
}