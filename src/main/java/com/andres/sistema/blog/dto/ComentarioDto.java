package com.andres.sistema.blog.dto;

public class ComentarioDto {

    private long id;
    private String nombre;
    private String email;
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
