package com.backend.security.service;

import com.backend.security.entity.Usuario;
import com.backend.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo UsuarioService **/
    UsuarioService usuarioService;

    @Override
    /** Funcion para cargar los datos del Usuario a traves del nombre de usuario **/
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
