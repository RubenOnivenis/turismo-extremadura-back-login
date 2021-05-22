package com.backend.models.dao;

import com.backend.models.entity.ForoTemas;
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
public class SpringJdbcForoTemasDao extends JdbcDaoSupport implements ForoTemasDao{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int insert(ForoTemas foroTemas) {

        String sql = "INSERT INTO foro_temas(nombre_tema, comentario_tema, id_usuario, fch_hora_tema) " +
                "VALUES (:nombre_tema, :comentario_tema, :id_usuario, sysdate) " +
                "WHERE id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre_tema", foroTemas.getNombreTema());
        params.addValue("comentario_tema", foroTemas.getComentarioTema());
        params.addValue("id_usuario", foroTemas.getIdUsuario());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int update(ForoTemas foroTemas) {

        String sql = "UPDATE foro_temas SET nombre_tema = :nombre_tema, comentario_tema = :comentario_tema " +
                "WHERE id_tema = :id_tema AND id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_tema", foroTemas.getIdTema());
        params.addValue("nombre_tema", foroTemas.getNombreTema());
        params.addValue("comentario_tema", foroTemas.getComentarioTema());
        params.addValue("id_usuario", foroTemas.getIdUsuario());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int delete(int idTema, int idUsuario) {

        String sql = "DELETE FROM foro_temas WHERE id_tema = :id_tema AND id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_tema", idTema);
        params.addValue("id_usuario", idUsuario);

        return getNamedJdbcTemplate().update(sql, params);
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class ForoTemasRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            ForoTemas foroTemas = new ForoTemas();

            foroTemas.setIdTema(rs.getInt("id_tema"));
            foroTemas.setNombreTema(rs.getString("nombre_tema"));
            foroTemas.setComentarioTema(rs.getString("comentario_tema"));
            foroTemas.setIdUsuario(rs.getInt("id_usuario"));
            foroTemas.setFchHoraTema(rs.getDate("fch_hora_tema"));

            return foroTemas;

        }

    }

}
