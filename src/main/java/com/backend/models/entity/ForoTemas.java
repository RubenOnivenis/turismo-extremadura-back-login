package com.backend.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="foro_temas")
public class ForoTemas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTema;
    private String nombreTema;
    private String comentarioTema;
    private int idUsuario;
    // Con esta anotación le proporcionamos la hora y fecha actual al campo
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fchHoraTema = new Date();

    public ForoTemas() { }

    public ForoTemas(int idTema, String nombreTema, String comentarioTema, int idUsuario, Date fchHoraTema) {
        this.idTema = idTema;
        this.nombreTema = nombreTema;
        this.comentarioTema = comentarioTema;
        this.idUsuario = idUsuario;
        this.fchHoraTema = fchHoraTema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getComentarioTema() {
        return comentarioTema;
    }

    public void setComentarioTema(String comentarioTema) {
        this.comentarioTema = comentarioTema;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFchHoraTema() {
        return fchHoraTema;
    }

    public void setFchHoraTema(Date fchHoraTema) {
        this.fchHoraTema = fchHoraTema;
    }
}
