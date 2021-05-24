package com.backend.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotBlank
    private String apellidos;
    private Date fch_nacimiento;
    private Blob imagen_perfil;
    private String telefono;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password,  @NotNull String apellidos, Date fch_nacimiento, Blob imagen_perfil, String telefono) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellidos= apellidos;
        this.fch_nacimiento= fch_nacimiento;
        this.imagen_perfil= imagen_perfil;
        this.telefono= telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

	public Blob getImagen_perfil() {
		return imagen_perfil;
	}

	public void setImagen_perfil(Blob imagen_perfil) {
		this.imagen_perfil = imagen_perfil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
