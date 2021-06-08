package com.backend.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

    /** Con esta anotación indicamos que no puede ser null ni estar vacío**/
    @NotBlank
    private String nombreUsuario;
    /** Con esta anotación indicamos que no puede ser null ni estar vacío**/
    @NotBlank
    private String password;

    /** GETTERS AND SETTERS **/

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
