package com.backend.dto;

public class Mensaje {

    /** Variable de tipo String **/
    private String mensaje;

    /** Constructor con variable **/
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /** GETTER AND SETTER **/
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
