package com.andres.sistema.blog.controllers;

import com.andres.sistema.blog.dto.PublicacionDto;
import com.andres.sistema.blog.dto.PublicacionRespuesta;
import com.andres.sistema.blog.services.PublicacionService;
import com.andres.sistema.blog.utility.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;


    @GetMapping
    public PublicacionRespuesta listarPublicaciones(
            @RequestParam(value = "pageNumber", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroPagina,
            @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaPagina,
            @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO, required = false) String ordenarPor,
            @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir){
        return publicacionService.obtenerTodasLasPublicaciones(numeroPagina, medidaPagina, ordenarPor, sortDir  );
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
