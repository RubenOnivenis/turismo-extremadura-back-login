package com.backend.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/** Implementamos los Detalles del Usuario**/
public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private String apellidos;
    private Date fch_nacimiento;
    private String telefono;
    private Collection<? extends GrantedAuthority> authorities;

    /** Contructor con las variables **/
    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, String apellidos, Date fch_nacimiento, String telefono, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellidos= apellidos;
        this.fch_nacimiento= fch_nacimiento;
        this.telefono= telefono;
        this.authorities = authorities;
    }

    /** Metodo para asignarle el rol al Usuario **/
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), usuario.getApellidos(), usuario.getFch_nacimiento(), usuario.getTelefono(), authorities);
    }

    /** GETTERS AND SETTERS **/
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public Date getFch_Nacimiento() {
        return fch_nacimiento;
    }
    
    public String getTelefono() {
        return telefono;
    }
}
