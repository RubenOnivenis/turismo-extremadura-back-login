package com.backend.models.services;

import com.backend.models.entity.Localizaciones;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacionesService {

    List<Localizaciones> findAll();

}
