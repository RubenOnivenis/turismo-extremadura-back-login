package com.backend.models.dao;

import com.backend.models.entity.Localizaciones;

import java.util.List;

public interface LocalizacionesDao {

    List<Localizaciones> getLocalizaciones();
    
    List<Localizaciones> getLocalizacionesByNombre(String nombre);
}
