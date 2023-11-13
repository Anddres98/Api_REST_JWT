package com.andres.sistema.blog.repository;

import com.andres.sistema.blog.dto.ComentarioDto;
import com.andres.sistema.blog.entitys.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    public List<Comentario> findByPublicacionId(long publicacionId);
}
