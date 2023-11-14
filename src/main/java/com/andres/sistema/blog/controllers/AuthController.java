package com.andres.sistema.blog.controllers;

import com.andres.sistema.blog.dto.LogginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/iniciarSesion")
    public ResponseEntity<String> authenticateUser(@RequestBody LogginDto logginDt){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(logginDt.getUsernameOrEmail(), logginDt.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("Ha Iniciado sesion con exito", HttpStatus.OK);


    }

}
