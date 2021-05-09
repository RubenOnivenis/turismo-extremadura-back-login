package com.backend.models.services;

import com.backend.models.entity.Localizaciones;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocalizacionesService {

    public List<Localizaciones> findAll();

}
