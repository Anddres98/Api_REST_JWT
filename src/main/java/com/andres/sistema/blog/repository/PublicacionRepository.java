package com.andres.sistema.blog.repository;

import com.andres.sistema.blog.entitys.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
