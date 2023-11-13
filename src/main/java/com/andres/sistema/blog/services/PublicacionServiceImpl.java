package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.dto.PublicacionRespuesta;
import com.andres.sistema.blog.entitys.Publicacion;
import com.andres.sistema.blog.exeptions.ResourceNotFoundException;
import com.andres.sistema.blog.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroPagina, int medidaPagina) {
        Pageable pageable = PageRequest.of(numeroPagina, medidaPagina);
        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);

        List<Publicacion> listaDePublicaciones = publicaciones.getContent();
        List<PublicacionDto> contenido = listaDePublicaciones.stream().map(this::mapearDTO).toList();

        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
        publicacionRespuesta.setContenido(contenido);
        publicacionRespuesta.setNumeroDePagina(publicaciones.getNumber());
        publicacionRespuesta.setMedidaDePagina(publicaciones.getSize());
        publicacionRespuesta.setTotalElemento(publicaciones.getTotalElements());
        publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
        publicacionRespuesta.setUltima(publicaciones.isLast());

        return publicacionRespuesta;
    }

    @Override
    public PublicacionDto obtenerPublicacionPorId(Long id) {
        Publicacion publicacion = publicacionRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
        return mapearDTO(publicacion);
    }

    @Override
    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, Long id) {
        Publicacion publicacion = publicacionRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));

        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        Publicacion publiActualizada = publicacionRepository.save(publicacion);
        return mapearDTO(publiActualizada);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        Publicacion publicacion = publicacionRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
        publicacionRepository.delete(publicacion);

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
