package com.backend.controllers;

import com.backend.models.entity.Alojamientos;

import com.backend.models.services.AlojamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class AlojamientosController {

    @Autowired
    AlojamientosService alojamientosService;

    // Controlador para ver todas los alojamientos
    @GetMapping("/alojamientos")
    public List<Alojamientos> alojamientosIndex(){

        return alojamientosService.findAll();
    }

    // Controlador para ver los alojamientos según el nombre, este sirve para el buscador del front
    @GetMapping("/alojamientos/nombre/{nombre}")
    public List<Alojamientos> getAlojamientosByName(@PathVariable String nombre){
        return alojamientosService.getAlojamientosByName(nombre);
    }
}
