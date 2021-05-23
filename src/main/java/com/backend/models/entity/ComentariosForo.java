package com.backend.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="comentarios_foro")
public class ComentariosForo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentarioForo;

    private String comentario;
    private int idUsuario;
    private int idTema;
    // Con esta anotación le proporcionamos la hora y fecha actual al campo
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fchHoraComentario = new Date();

    public ComentariosForo() { }

    public ComentariosForo(int idComentarioForo, String comentario, int idUsuario, int idTema, Date fchHoraComentario) {
        this.idComentarioForo = idComentarioForo;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.idTema = idTema;
        this.fchHoraComentario = fchHoraComentario;
    }

    public int getIdComentarioForo() {
        return idComentarioForo;
    }

    public void setIdComentarioForo(int idComentarioForo) {
        this.idComentarioForo = idComentarioForo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public Date getFchHoraComentario() {
        return fchHoraComentario;
    }

    public void setFchHoraComentario(Date fchHoraComentario) {
        this.fchHoraComentario = fchHoraComentario;
    }
}
