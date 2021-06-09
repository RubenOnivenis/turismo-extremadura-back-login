package com.backend.security.repository;

import com.backend.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Repository es una anotacion de Spring que indica que la clase decorada es un repositorio.
 * es un mecanismo para encapsular el comportamiento de almacenamiento,
 * recuperación y búsqueda que emula una colección de objetos.
 * **/
@Repository
/** Interfaz que extiende de JpaRepository < Rol, Integer > **/
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    /** Comprueba si existe el nombre de usuario **/
    boolean existsByNombreUsuario(String nombreUsuario);
    /** Comprueba si existe el email **/
    boolean existsByEmail(String email);

}
