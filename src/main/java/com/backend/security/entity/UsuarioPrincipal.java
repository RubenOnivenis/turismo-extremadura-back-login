package com.backend.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Blob;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private String apellidos;
    private Date fch_nacimiento;
    private Blob imagen_perfil;
    private String telefono;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, String apellidos, Date fch_nacimiento, Blob imagen_perfil, String telefono, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellidos= apellidos;
        this.fch_nacimiento= fch_nacimiento;
        this.imagen_perfil= imagen_perfil;
        this.telefono= telefono;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), usuario.getApellidos(), usuario.getFch_nacimiento(), usuario.getImagen_perfil(), usuario.getTelefono(), authorities);
    }

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
    
    public Blob getImagen_Perfil() {
        return imagen_perfil;
    }
    
    public String getTelefono() {
        return telefono;
    }
}
