package com.backend.models.dao;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosDao {

    List<Alojamientos> getAlojamientos();

    List<Alojamientos> getAlojamientosByName(String nombre);
}
