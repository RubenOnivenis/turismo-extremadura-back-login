package com.backend.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/** Con la antoación @Entity indicamos que es una entidad **/
@Entity
/** Se indica como se llama la tabla de esta entidad **/
@Table(name = "usuario")
public class Usuario {
	
	/** Variables

    /**Con esta anotación indicamos que es el Identificador de la tabla **/
    @Id
    /** Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    private String nombre;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    /** Con esta anotación se configura que sea una Clave Unica **/
    @Column(unique = true)
    private String nombreUsuario;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    private String email;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    private String password;
    /** Con esta anotación se configura que no sea NULL **/
    @NotBlank
    private String apellidos;
    private Date fch_nacimiento;
    private String telefono;
    /** Con esta anotación se configura que no sea NULL **/
    @NotNull
    /** Con esta anotación se configura que la relaciones en la Base de Datos sea Muchos a Muchos **/
    @ManyToMany(fetch = FetchType.EAGER)
    /** Con esta anotación se configura la relación entre las Tablas de la Base de Datos **/
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    /** Contructor de la clase **/
    public Usuario() {
    }

    /** Contructor con las variables **/
    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password,  @NotNull String apellidos, Date fch_nacimiento, String telefono) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellidos= apellidos;
        this.fch_nacimiento= fch_nacimiento;
        this.telefono= telefono;
    }
    
    /** GETTERS AND SETTERS **/

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
