package com.backend.security.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.Mensaje;
import com.backend.security.dto.JwtDto;
import com.backend.security.dto.LoginUsuario;
import com.backend.security.dto.NuevoUsuario;
import com.backend.security.entity.Rol;
import com.backend.security.entity.Usuario;
import com.backend.security.enums.RolNombre;
import com.backend.security.jwt.JwtProvider;
import com.backend.security.service.RolService;
import com.backend.security.service.UsuarioService;

/** Anotacion que nos indica que es una clase para controladores **/
@RestController
/** Anotacion para el mapeo, le indicamos que /auth ira al principio **/
@RequestMapping("/auth")
/** Anotacion que define la interacción entre un navegador y un servidor para manejar de forma segura las solicitudes HTTP **/
@CrossOrigin
public class AuthController {

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable passwordEncoder de tipo PasswordEncoder **/
    PasswordEncoder passwordEncoder;
    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable authenticationManager de tipo AuthenticationManager **/
    AuthenticationManager authenticationManager;
    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable usuarioService de tipo usuarioService **/
    UsuarioService usuarioService;
    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable rolService de tipo RolService **/
    RolService rolService;
    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** variable jwtProvider de tipo JwtProvider **/
    JwtProvider jwtProvider;

    /** Anotación con la cual indicamos que es una petición de tipo POST y en el endpoint se escribirá /nuevo **/
    @PostMapping("/nuevo")
    /**  **/
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getApellidos(), nuevoUsuario.getFch_nacimiento(), nuevoUsuario.getTelefono());
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    /** Anotación con la cual indicamos que es una petición de tipo POST y en el endpoint se escribirá /login **/
    @PostMapping("/login")
    /**  **/
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    /** Anotación con la cual indicamos que es una petición de tipo POST y en el endpoint se escribirá /refresh **/
    @PostMapping("/refresh")
    /**  **/
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }
}
