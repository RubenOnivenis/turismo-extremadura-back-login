package com.backend.controllers;

import com.backend.models.entity.ForoTemas;
import com.backend.models.services.ForoTemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ForoTemasController {

    @Autowired private ForoTemasService foroTemasService;

    @PostMapping("/temas_foro") @ResponseStatus(HttpStatus.CREATED)
    public int create (@RequestBody ForoTemas foroTemas){
        return foroTemasService.save(foroTemas);
    }

    @PutMapping("/temas_foro/{id_tema}")
    public int update(@RequestBody ForoTemas foroTemas, @PathVariable int id_tema){

        foroTemas.setIdTema(id_tema);

        return foroTemasService.update(foroTemas);
    }

    @DeleteMapping("/temas_foro/{id_tema}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public int delete(@PathVariable int id_tema, int idUsuario){
        return foroTemasService.delete(id_tema, idUsuario);
    }

}
