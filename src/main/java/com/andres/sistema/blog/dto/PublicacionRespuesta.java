package com.andres.sistema.blog.dto;

import java.util.List;

public class PublicacionRespuesta {

    private List<PublicacionDto> contenido;
    private int numeroDePagina;
    private int medidaDePagina;
    private long totalElemento;
    private int totalPaginas;
    private boolean ultima;


    public PublicacionRespuesta() {
    }

    public List<PublicacionDto> getContenido() {
        return contenido;
    }

    public void setContenido(List<PublicacionDto> contenido) {
        this.contenido = contenido;
    }

    public int getNumeroDePagina() {
        return numeroDePagina;
    }

    public void setNumeroDePagina(int numeroDePagina) {
        this.numeroDePagina = numeroDePagina;
    }

    public int getMedidaDePagina() {
        return medidaDePagina;
    }

    public void setMedidaDePagina(int medidaDePagina) {
        this.medidaDePagina = medidaDePagina;
    }

    public long getTotalElemento() {
        return totalElemento;
    }

    public void setTotalElemento(long totalElemento) {
        this.totalElemento = totalElemento;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public boolean isUltima() {
        return ultima;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }
}
