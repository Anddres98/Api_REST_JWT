package com.andres.sistema.blog.dto;

public class PublicacionDto {

    private Long id;
    private String titulo;
    private String descripcion;
    private String cotenido;

    public PublicacionDto(Long id, String titulo, String descripcion, String cotenido) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cotenido = cotenido;
    }

    public PublicacionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCotenido() {
        return cotenido;
    }

    public void setCotenido(String cotenido) {
        this.cotenido = cotenido;
    }
}
