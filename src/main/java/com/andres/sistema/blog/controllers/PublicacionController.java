package com.andres.sistema.blog.controllers;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;


    @GetMapping
    public List<PublicacionDto> listarPublicaciones(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int numeroPagina,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int medidaPagina){
        return publicacionService.obtenerTodasLasPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDto> obtenerPublicacionPorId(
            @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(publicacionService.obtenerPublicacionPorId(id));
    }

    @PostMapping
    public ResponseEntity<PublicacionDto> guardarPublicacion(@RequestBody PublicacionDto publicacionDto){
        return new ResponseEntity<>(publicacionService.crearPublicacion(publicacionDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDto> actualizarPublicacion(
            @RequestBody PublicacionDto publicacionDto,
            @PathVariable(name = "id") Long id){
        PublicacionDto publicacionRespuesta = publicacionService.actualizarPublicacion(publicacionDto, id);
        return new ResponseEntity<>(publicacionRespuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(
            @PathVariable(name = "id") Long id){
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicacion Eliminada con exito", HttpStatus.OK);
    }

}
