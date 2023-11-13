package com.andres.sistema.blog.controllers;

import com.andres.sistema.blog.dto.ComentarioDto;
import com.andres.sistema.blog.entitys.Comentario;
import com.andres.sistema.blog.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDto> guardarComentario(
            @PathVariable(value = "publicacionId") Long publicacionId,
            @RequestBody ComentarioDto comentarioDto){
        return new ResponseEntity<>(comentarioService.crearComentario(publicacionId, comentarioDto), HttpStatus.CREATED);
    }

    @GetMapping("publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDto> listarComentariosPorPublicacionId(
            @PathVariable(value = "publicacionId") Long publicacionId) {
        return comentarioService.obtenerComentariosPorPublicacionID(publicacionId);
    }

    @GetMapping("publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDto> obtenerComentarioPorId(
            @PathVariable(value = "pubalicionId") Long publicacionId,
            @PathVariable(value = "id") Long comentarioId){
        ComentarioDto comentarioDto = comentarioService.obtenerComentarioPorId(publicacionId, comentarioId);
        return new ResponseEntity<>(comentarioDto, HttpStatus.OK);
    }
}
