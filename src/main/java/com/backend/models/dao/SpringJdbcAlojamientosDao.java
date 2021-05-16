package com.backend.models.dao;

import com.backend.models.entity.Alojamientos;
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
public class SpringJdbcAlojamientosDao extends JdbcDaoSupport implements AlojamientosDao {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    @Override
    public List<Alojamientos> getAlojamientos() {
        String sql = "SELECT a.id_alojamiento, a.imagen, a.nombre, l.nombre, a.descripcion FROM alojamientos a INNER JOIN localizaciones l " +
                "ON a.id_localizacion = l.id_localizacion;";

        return getJdbcTemplate().query(sql, new SpringJdbcAlojamientosDao.AlojamientosRowMapper());
    }

    @Override
    public List<Alojamientos> getAlojamientosByName(String nombre) {

        String sql = "SELECT a.imagen, a.nombre, l.nombre, a.descripcion FROM alojamientos a INNER JOIN localizaciones l " +
                "ON a.id_localizacion = l.id_localizacion WHERE a.nombre = :nombre OR l.nombre = :nombre;";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", nombre);

        return getNamedJdbcTemplate().query(sql, params, new AlojamientosRowMapper());
    }

    private class AlojamientosRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            Alojamientos alojamientos = new Alojamientos();

            alojamientos.setIdAlojamiento(rs.getInt("id_alojamiento"));
            alojamientos.setIdLocalizacion(rs.getInt("id_localizacion"));
            alojamientos.setImagen(rs.getString("imagen"));
            alojamientos.setNombre(rs.getString("nombre"));
            alojamientos.setDescripcion(rs.getString("descripcion"));

            return alojamientos;

        }

    }

}
