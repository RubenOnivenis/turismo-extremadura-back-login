package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;
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

@Repository
public class SpringJdbcComentariosForoDao extends JdbcDaoSupport implements ComentariosForoDao{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public int insert(ComentariosForo comentariosForo) {
        String sql = "INSERT INTO comentarios_foro(comentario, id_usuario, id_tema, fch_hora_tema) " +
                "VALUES (:comentario, :id_usuario, :id_tema, sysdate) " +
                "WHERE id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_usuario", comentariosForo.getIdUsuario());
        params.addValue("id_tema", comentariosForo.getIdTema());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int update(ComentariosForo comentariosForo) {

        String sql = "UPDATE comenarios_foro SET comentario = :comentario WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_comentario_foro", comentariosForo.getIdComentarioForo());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int delete(int idComentarioForo, int idUsuario) {

        String sql = "DELETE FROM comenarios_foro WHERE id_comentario_foro = :id_comentario_foro AND id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comentario_foro", idComentarioForo);
        params.addValue("id_usuario", idUsuario);

        return getNamedJdbcTemplate().update(sql, params);
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class ComentariosForoRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            ComentariosForo comentariosForo = new ComentariosForo();

            comentariosForo.setIdComentarioForo(rs.getInt("id_comentario_foro"));
            comentariosForo.setComentario(rs.getString("comentario"));
            comentariosForo.setIdUsuario(rs.getInt("id_usuario"));
            comentariosForo.setIdTema(rs.getInt("id_tema"));
            comentariosForo.setFchHoraComentario(rs.getDate("fch_hora_comentario"));

            return comentariosForo;

        }

    }
}
