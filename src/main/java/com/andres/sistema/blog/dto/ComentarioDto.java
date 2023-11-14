package com.andres.sistema.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ComentarioDto {


    private long id;
    @NotEmpty(message = "El nombre no debe estar vacio o nulo")
    private String nombre;
    @Email
    @NotEmpty(message = "El email no debe ser vacio o null")
    private String email;
    @NotEmpty
    @Size(min = 10, message = "El contenido del mensaje debe tener al menos 10 caracteres")
    private String contenidoDelMensaje;


    public ComentarioDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContenidoDelMensaje() {
        return contenidoDelMensaje;
    }

    public void setContenidoDelMensaje(String contenidoDelMensaje) {
        this.contenidoDelMensaje = contenidoDelMensaje;
    }
}
