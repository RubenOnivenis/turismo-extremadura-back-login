package com.backend.controllers;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.services.ComentariosForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ComentariosForoController {

    @Autowired private ComentariosForoService comentariosForoService;

    @PostMapping("/comentario_foro") @ResponseStatus(HttpStatus.CREATED)
    public int create(@RequestBody ComentariosForo comentariosForo){
        return comentariosForoService.save(comentariosForo);
    }

    @PutMapping("/comentario_foro/{id_comentario_foro}")
    public int update(@RequestBody ComentariosForo comentariosForo, @PathVariable int idComentarioForo){
        comentariosForo.setIdComentarioForo(idComentarioForo);

        return comentariosForoService.update(comentariosForo);
    }

    @DeleteMapping("/comentario_foro/{id_comentario_foro}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public int delete(@PathVariable int id_comentario_foro, int idUsuario){
        return comentariosForoService.delete(id_comentario_foro, idUsuario);
    }
}
