package com.backend.controllers;

import com.backend.models.entity.Alojamientos;
import com.backend.models.services.AlojamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class AlojamientosController {

    @Autowired
    AlojamientosService alojamientosService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/alojamientos")
    public List<Alojamientos> getAlojamientosByName(@PathVariable String nombre){
        return alojamientosService.getAlojamientosByName(nombre);
    }
}
