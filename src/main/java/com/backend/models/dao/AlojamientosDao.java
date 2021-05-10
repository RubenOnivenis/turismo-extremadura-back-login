package com.backend.models.dao;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosDao {

    public List<Alojamientos> getAlojamientosByName(String nombre);
}
