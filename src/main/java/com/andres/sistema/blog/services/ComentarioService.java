package com.andres.sistema.blog.services;

import com.andres.sistema.blog.dto.ComentarioDto;
import com.andres.sistema.blog.entitys.Comentario;


import java.util.List;

public interface ComentarioService {

    public ComentarioDto crearComentario(Long publicacionId, ComentarioDto comentarioDto);
    public List<ComentarioDto> obtenerComentariosPorPublicacionID(Long publicacionId);

    public ComentarioDto obtenerComentarioPorId(Long publicacionId, Long comentarioId);

    public ComentarioDto actualizarComentario(Long publicacionId, Long comentarioId,ComentarioDto solicitudDeComentario);

    public void eliminarComentario (Long publicacionId, Long comentarioId);
}
