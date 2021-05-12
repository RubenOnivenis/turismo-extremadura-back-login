package com.backend.models.services;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosService {

    List<Alojamientos> findAll();

    List<Alojamientos> getAlojamientosByName(String nombre);
}
