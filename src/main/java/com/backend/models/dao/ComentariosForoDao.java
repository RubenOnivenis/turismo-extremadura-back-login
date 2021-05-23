package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.entity.ForoTemas;

public interface ComentariosForoDao {

    int insert(ComentariosForo comentariosForo);

    int update(ComentariosForo comentariosForo);

    int delete(int idComentarioForo, int idUsuario);
}
