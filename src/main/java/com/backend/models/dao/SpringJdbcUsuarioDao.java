package com.backend.models.dao;

import com.backend.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcUsuarioDao extends JdbcDaoSupport implements UsuarioDao{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Usuario> getUsuarios() {
        String sql = "SELECT * FROM usuario;";
        return getJdbcTemplate().query(sql, new UsuarioRowMapper());
    }

    @Override
    public Usuario getUsuarioById(int id_usuario) {
        String sql = "SELECT * FROM usuario WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id_usuario);	//Cuando se encuentren :id lo cambiara por la variable id que nos llega del método

        return (Usuario) getNamedJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM usuario WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int update(Usuario usuario) {
        String sql = "UPDATE usuario SET "
                + "nombre_usuario = :nombre_usuario, nombre = :nombre, apellidos = :apellidos, fch_nacimiento = :fch_nacimiento, "
                + "email = :email, imagen_perfil = :imagen_perfil, telefono=:telefono "
                + "WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("nombre_usuario", usuario.getNombreUsuario());
        params.addValue("nombre", usuario.getNombre());
        params.addValue("apellidos", usuario.getApellidos());
        params.addValue("fch_nacimiento", usuario.getFch_nacimiento());
        params.addValue("email", usuario.getEmail());
        params.addValue("imagen_perfil", usuario.getImagen_perfil());
        params.addValue("telefono", usuario.getTelefono());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int updatePass(Usuario usuario) {

        String sql = "UPDATE usuario SET password = :password WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("password", usuario.getPassword());

        return getNamedJdbcTemplate().update(sql, params);
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class UsuarioRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setFch_nacimiento(rs.getDate("fch_nacimietno"));
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
            usuario.setImagen_perfil(rs.getBlob("imagen_perfil"));
            usuario.setTelefono(rs.getString("telefono"));

            return usuario;

        }

    }

}
