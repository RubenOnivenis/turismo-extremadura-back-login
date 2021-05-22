package com.backend.models.services;

import com.backend.models.entity.ForoTemas;

public interface ForoTemasService {

    int save(ForoTemas foroTemas);

    int delete(int idTema, int idUsuario);

    int insert (ForoTemas foroTemas);

    int update (ForoTemas foroTemas);

}
