package com.backend.security.entity;

import com.backend.security.enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** Con la antoación @Entity indicamos que es una entidad **/
@Entity
public class Rol {
	
	/** Variables

    /**Con esta anotación indicamos que es el Identificador de la tabla **/
    @Id
    /** Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    /** Con esta anotación se configura sea un tipo Enum de string**/
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    /** Contructor de la clase **/
    public Rol() {
    }

    /** Contructor con las variables **/
    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    /** GETTERS AND SETTERS **/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
