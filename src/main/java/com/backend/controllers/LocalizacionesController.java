package com.backend.controllers;

import com.backend.models.entity.Localizaciones;
import com.backend.models.services.LocalizacionesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LocalizacionesController {

    @Autowired
    private LocalizacionesService localizacionesService;

    // Controlador para ver todas las localizaciones
    @GetMapping("/localizaciones")
    public List<Localizaciones> localizacionesIndex(){

        return localizacionesService.findAll();
    }
    
    @GetMapping("/productos/nombre/{nombre}")
	public List<Localizaciones> show(@PathVariable String nombre) {
		return localizacionesService.findByName(nombre);
	}
}
