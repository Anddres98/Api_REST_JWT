package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.PublicacionDto;

import java.util.List;

public interface PublicacionService {

    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);
    public List<PublicacionDto> obtenerTodasLasPublicaciones();

    public PublicacionDto obtenerPublicacionPorId(Long id);

    public PublicacionDto actualizarPublicacion
}
