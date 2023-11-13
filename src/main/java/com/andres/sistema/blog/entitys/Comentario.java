package com.andres.sistema.blog.entitys;
import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String contenidoDelMensaje;

    //Usamos lazy para decir que solo muestre cuando lo necesite
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Long id, String nombre, String email, String contenidoDelMensaje, Publicacion publicacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contenidoDelMensaje = contenidoDelMensaje;
        this.publicacion = publicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
