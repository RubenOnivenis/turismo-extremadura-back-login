package com.backend.models.services;

import com.backend.security.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> findAll();

   // public int save(Usuario usuario);

    public int delete(int id);

    public Usuario findById(int id);

   // public int insert(Usuario usuario);

    public int update(Usuario usuario);

    public int updatePass(Usuario usuario);

}
