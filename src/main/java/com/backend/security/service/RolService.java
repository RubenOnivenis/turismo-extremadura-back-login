package com.backend.security.service;

import com.backend.security.entity.Rol;
import com.backend.security.enums.RolNombre;
import com.backend.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Anotacion para indicar que es un metadato que especifica que una interfaz, clase o método debe tener semántica transaccional **/
@Transactional
public class RolService {
	
	/** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo RolRepository **/
    RolRepository rolRepository;

    /** Funcion de tipo opcional del obj Rol, que obtiene el rol por su nombre **/
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    /** Funcion de tipo void del obj Rol, que guarda los nuevos roles **/
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
