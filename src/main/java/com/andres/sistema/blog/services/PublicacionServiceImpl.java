package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.entitys.Publicacion;
import com.andres.sistema.blog.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {
        //convertir de Dto a Entidad
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getCotenido());

        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);

        //convertimos de Entidad a DTO
        PublicacionDto publicacionDto1 = new PublicacionDto();
        publicacionDto.setTitulo(nuevaPublicacion.getTitulo());
        publicacionDto.setDescripcion(nuevaPublicacion.getDescripcion());
        publicacionDto.setCotenido(nuevaPublicacion.getContenido());

        return publicacionDto1;
    }
}
