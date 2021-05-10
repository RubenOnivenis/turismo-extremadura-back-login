package com.backend.models.services;

import com.backend.models.dao.AlojamientosDao;
import com.backend.models.entity.Alojamientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlojamientosServiceImpl implements AlojamientosService{

    @Autowired
    AlojamientosDao alojamientosDao;

    @Override
    public List<Alojamientos> getAlojamientosByName(String nombre) {
        return alojamientosDao.getAlojamientosByName(nombre);
    }
}
