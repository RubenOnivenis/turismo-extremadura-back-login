package com.backend.models.services;

import com.backend.models.entity.ComentariosForo;

public interface ComentariosForoService {

    int save(ComentariosForo comentariosForo);

    int delete(int idComentarioForo, int idUsuario);

    int insert (ComentariosForo comentariosForo);

    int update (ComentariosForo comentariosForo);

}
