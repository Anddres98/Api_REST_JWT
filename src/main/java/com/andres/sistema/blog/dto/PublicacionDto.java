package com.andres.sistema.blog.dto;

import com.andres.sistema.blog.entitys.Comentario;

import java.util.Set;

public class PublicacionDto {

    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;

    private Set<Comentario> comentarios;


    public PublicacionDto(Long id, String titulo, String descripcion, String cotenido) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = cotenido;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String cotenido) {
        this.contenido = cotenido;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
