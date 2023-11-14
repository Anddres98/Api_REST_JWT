package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.ComentarioDto;
import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.entitys.Comentario;
import com.andres.sistema.blog.entitys.Publicacion;
import com.andres.sistema.blog.exeptions.BlogAppException;
import com.andres.sistema.blog.exeptions.ResourceNotFoundException;
import com.andres.sistema.blog.repository.ComentarioRepository;
import com.andres.sistema.blog.repository.PublicacionRepository;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public ComentarioDto crearComentario(Long publicacionId, ComentarioDto comentarioDto) {
        Comentario comentario = mapearEntidad(comentarioDto);
        Publicacion publicacion = publicacionRepository.findById(publicacionId).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        comentario.setPublicacion(publicacion);
        Comentario nuevoComentario = comentarioRepository.save(comentario);
        return mapearDTO(comentario);
    }

    @Override
    public List<ComentarioDto> obtenerComentariosPorPublicacionID(Long publicacionId) {
        List<Comentario> comentarios = comentarioRepository.findByPublicacionId(publicacionId);

        return comentarios.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ComentarioDto obtenerComentarioPorId(Long publicacionId, Long comentarioId) {

        Publicacion publicacion = publicacionRepository.findById(publicacionId).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", publicacionId));
        Comentario comentario = comentarioRepository.findById(comentarioId).
                orElseThrow(()-> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        return mapearDTO(comentario);
    }

    @Override
    public ComentarioDto actualizarComentario(Long publicacionId, Long comentarioId,ComentarioDto solicitudDeComentario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        Comentario comentario = comentarioRepository.findById(comentarioId).
                orElseThrow(()-> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        comentario.setNombre(solicitudDeComentario.getNombre());
        comentario.setEmail(solicitudDeComentario.getEmail());
        comentario.setContenidoDelMensaje(solicitudDeComentario.getContenidoDelMensaje());
        Comentario comentarioActualizado = comentarioRepository.save(comentario);

        return mapearDTO(comentarioActualizado);
    }

    @Override
    public void eliminarComentario(Long publicacionId, Long comentarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId).
                orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        Comentario comentario = comentarioRepository.findById(comentarioId).
                orElseThrow(()-> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }
        comentarioRepository.delete(comentario);
    }

    private ComentarioDto mapearDTO(Comentario comentario){

        return modelMapper.map(comentario, ComentarioDto.class);
    }

    private Comentario mapearEntidad(ComentarioDto comentarioDto){

        return modelMapper.map(comentarioDto, Comentario.class);
    }
}
