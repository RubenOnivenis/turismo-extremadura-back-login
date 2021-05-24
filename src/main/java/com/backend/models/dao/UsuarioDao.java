package com.backend.models.dao;

import com.backend.security.entity.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario getUsuarioById(int id_usuario);

    int delete(int id);

    int update(Usuario usuario);

    int updatePass(Usuario usuario);
}
