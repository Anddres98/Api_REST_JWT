package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.entitys.Publicacion;
import com.andres.sistema.blog.exeptions.ResourceNotFoundException;
import com.andres.sistema.blog.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {
        //convertir de Dto a Entidad
        Publicacion publicacion = mapearEntidad(publicacionDto);
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);

        //convertimos de Entidad a DTO
        PublicacionDto publicacionDto1 = mapearDTO(nuevaPublicacion);

        return publicacionDto1;
    }

    @Override
    public List<PublicacionDto> obtenerTodasLasPublicaciones() {
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public PublicacionDto obtenerPublicacionPorId(Long id) {
        Publicacion publicacion = publicacionRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
        return mapearDTO(publicacion);
    }

    //Convierte Entidad a DTO
    private PublicacionDto mapearDTO(Publicacion publicacion){
        PublicacionDto publicacionDto = new PublicacionDto();

        publicacionDto.setId(publicacion.getId());
        publicacionDto.setTitulo(publicacion.getTitulo());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());
        return publicacionDto;
    }

    //Convierte de DTO a Entidad
    private Publicacion mapearEntidad(PublicacionDto publicacionDto){
        Publicacion publicacion = new Publicacion();

        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());
        return publicacion;
    }
}
