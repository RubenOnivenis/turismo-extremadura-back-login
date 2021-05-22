package com.backend.models.dao;

import com.backend.models.entity.ForoTemas;

public interface ForoTemasDao {

    int insert(ForoTemas foroTemas);

    int update(ForoTemas foroTemas);

    int delete(int idTema, int idUsuario);
}
