package com.andres.sistema.blog.configuracion;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


import org.springframework.security.crypto.password.PasswordEncoder;


//para crear una web security personalisada se usa EnableWebSecurity
// Para redefinir methods se extiende WebsecurityConfiguration


public class SecurityConfig extends WebSecurityConfiguration {



}
