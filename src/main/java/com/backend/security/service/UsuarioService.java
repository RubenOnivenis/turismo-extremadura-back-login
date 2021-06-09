package com.backend.security.service;

import com.backend.security.entity.Usuario;
import com.backend.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Anotacion para indicar que es un metadato que especifica que una interfaz, clase o método debe tener semántica transaccional **/
@Transactional
public class UsuarioService {

	/** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo UsuarioRepository **/
    UsuarioRepository usuarioRepository;

    /** Funcion de tipo opcional del obj Usuario, que obtiene el usuario por el nombre de usuario **/
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    /** Funcion de tipo boolean, que comprueba si existe el nombre de usuario **/
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    /** Funcion de tipo boolean, que comprueba si existe el email del usuario **/
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    /** Funcion de tipo void, que guarda los nuevos usuarios **/
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
