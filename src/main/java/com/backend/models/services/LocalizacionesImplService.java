package com.backend.models.services;

import com.backend.models.dao.LocalizacionesDao;
import com.backend.models.entity.Localizaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacionesImplService {

    @Autowired private LocalizacionesDao localizacionesDao;

    public List<Localizaciones> findAll(){
        return localizacionesDao.getLocalizaciones();
    }
}
