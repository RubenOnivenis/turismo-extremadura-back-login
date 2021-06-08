package com.backend.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {

    /** Con esta anotacion indicamos que no puede ser null ni estar vacio**/
    @NotBlank
    private String nombre;
    /** Con esta anotacion indicamos que no puede ser null ni estar vacio**/
    @NotBlank
    private String nombreUsuario;
    /** Con esta anotacion indicamos que no puede el campo es email **/
    @Email
    private String email;
    /** Con esta anotacion indicamos que no puede ser null ni estar vacio **/
    @NotBlank
    private String password;
    /** Con esta anotacion indicamos que no puede ser null ni estar vacio **/
    @NotBlank
    private String apellidos;
    private Date fch_nacimiento;
    private String telefono;
    /**  la clase HashSet es aquella que implementa la interfaz Set que respaldada por una tabla hash en realidad es una instancia de HashMap. **/
    private Set<String> roles = new HashSet<>();


    /** GETTERS AND SETTERS **/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFch_nacimiento() {
		return fch_nacimiento;
	}

	public void setFch_nacimiento(Date fch_nacimiento) {
		this.fch_nacimiento = fch_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
