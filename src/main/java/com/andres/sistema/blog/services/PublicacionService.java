package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.dto.PublicacionRespuesta;


public interface PublicacionService {

    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroPagina, int medidaPagina);

    public PublicacionDto obtenerPublicacionPorId(Long id);

    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, Long id);

    public void eliminarPublicacion(Long id);
}
