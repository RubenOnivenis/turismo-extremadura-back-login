package com.backend.models.services;


import com.backend.models.dao.ComentariosForoDao;
import com.backend.models.entity.ComentariosForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentariosForoServiceImpl implements ComentariosForoService {

    @Autowired
    private ComentariosForoDao comentariosForoDao;

    @Override
    public int save(ComentariosForo comentariosForo) {
        return comentariosForoDao.insert(comentariosForo);
    }

    @Override
    public int delete(int idComentarioForo, int idUsuario) {
        return comentariosForoDao.delete(idComentarioForo, idUsuario);
    }

    @Override
    public int insert(ComentariosForo comentariosForo) {
        return comentariosForoDao.update(comentariosForo);
    }

    @Override
    public int update(ComentariosForo comentariosForo) {
        return comentariosForoDao.update(comentariosForo);
    }
}
