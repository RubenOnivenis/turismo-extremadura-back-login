package com.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.security.jwt.JwtEntryPoint;
import com.backend.security.jwt.JwtTokenFilter;
import com.backend.security.service.UserDetailsServiceImpl;

/** Anotación encargada de definir que la clase es una clase de configuración para el framework **/
@Configuration
/** EnableWebSecurity es una anotación de marcador.
 * Permite que Spring encuentre (es un @Configuration y, por lo tanto, @Component )
 * y aplica automáticamente la clase al global WebSecurity .
 * **/
@EnableWebSecurity
/** EnableGlobalMethodSecurity habilita la seguridad de metodo de spring **/
@EnableGlobalMethodSecurity(prePostEnabled = true)
/** Extendemos de WebSecurityConfigurerAdapter **/
public class MainSecurity extends WebSecurityConfigurerAdapter {

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable userDetailsService de tipo UserDetailsServiceImpl **/
    UserDetailsServiceImpl userDetailsService;

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable jwtEntryPoin de tipo JwtEntryPoint **/
    JwtEntryPoint jwtEntryPoint;

    /** Los Beans son objetos que maneja el contendor de spring **/
    @Bean
    /** Funcion jwtTokenFilter de tipo JwtTokenFilter **/
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    /** Los Beans son objetos que maneja el contendor de spring **/
    @Bean
    /** Funcion passwordEncoder de tipo PasswordEncoder **/
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    /** Funcion configure que llama a la variable auth de tipo AuthenticationManagerBuilder **/
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /** Los Beans son objetos que maneja el contendor de spring **/
    @Bean
    @Override
    /** Funcion de tipo AuthenticationManager **/
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    /** Funcion de tipo AuthenticationManager **/
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    /** Funcion configure que llama a la variable http de tipo HttpSecurity **/
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
