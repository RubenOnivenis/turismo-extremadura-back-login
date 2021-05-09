package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity @Table(name="localizaciones")
public class Localizaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocalizacion;

    private String nombre;
    private String provincia;
    private String comarca;
    private String imagen;

    public Localizaciones(){}

    public Localizaciones(int idLocalizacion, String nombre, String provincia, String comarca, String imagen) {
        this.idLocalizacion = idLocalizacion;
        this.nombre = nombre;
        this.provincia = provincia;
        this.comarca = comarca;
        this.imagen = imagen;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
