package com.andres.sistema.blog.repository;

import com.andres.sistema.blog.entitys.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RolRepository extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByNombre(String nombre);
}
