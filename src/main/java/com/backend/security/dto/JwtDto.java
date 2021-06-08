package com.backend.security.dto;


public class JwtDto {

    /** Variable tipo String **/
    private String token;

    /** Constructor de la clase **/
    public JwtDto() { }

    /** Constructor de la clase con las variables **/
    public JwtDto(String token) {
        this.token = token;
    }

    /** Getter **/
    public String getToken() {
        return token;
    }

    /** SETTER **/
    public void setToken(String token) {
        this.token = token;
    }


}
