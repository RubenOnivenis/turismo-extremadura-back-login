package com.backend.util;

import com.backend.security.entity.Rol;
import com.backend.security.enums.RolNombre;
import com.backend.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 */

/** Component: Es el estereotipo general y permite anotar un bean para que Spring lo considere uno de sus objetos. **/
@Component
public class CreateRoles implements CommandLineRunner {

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable rolService de tipo RolService **/
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /** Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
         **/
    }
}
