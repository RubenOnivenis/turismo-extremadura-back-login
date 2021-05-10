package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name="alojamientos")
public class Alojamientos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlojamiento;

    private int idLocalizacion;
    private String imagen;
    private String nombre;

    public Alojamientos(){}

    public Alojamientos(int idAlojamiento, int idLocalizacion, String imagen, String nombre) {
        this.idAlojamiento = idAlojamiento;
        this.idLocalizacion = idLocalizacion;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
