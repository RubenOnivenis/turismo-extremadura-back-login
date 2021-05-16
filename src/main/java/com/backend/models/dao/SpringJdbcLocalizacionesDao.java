package com.backend.models.dao;

import com.backend.models.entity.Localizaciones;

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
public class SpringJdbcLocalizacionesDao extends JdbcDaoSupport implements LocalizacionesDao {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Localizaciones> getLocalizaciones(){

        String sql = "SELECT id_localizacion, nombre, provincia, comarca, imagen FROM  localizaciones;";
        return getJdbcTemplate().query(sql, new localizacionesRowMapper());

    }
    
    @Override
	public List<Localizaciones> getLocalizacionesByNombre(String nombre) {
		// TODO Auto-generated method stub
		String SQL="SELECT id_localizacion, nombre, provincia, comarca, imagen FROM localizaciones WHERE nombre LIKE CONCAT('%',:nombre,'%');";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre", nombre);

		return getNamedJdbcTemplate().query(SQL, params, new localizacionesRowMapper());
	}
	

    private NamedParameterJdbcTemplate getNamedJdbcTemplate() {

        if (this.namedParameterJdbcTemplate == null) {

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }

        return this.namedParameterJdbcTemplate;

    }

    private class localizacionesRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException{

            Localizaciones localizaciones = new Localizaciones();

            localizaciones.setIdLocalizacion(rs.getInt("id_localizacion"));
            localizaciones.setNombre(rs.getString("nombre"));
            localizaciones.setProvincia(rs.getString("provincia"));
            localizaciones.setComarca(rs.getString("comarca"));
            localizaciones.setImagen(rs.getString("imagen"));

            return localizaciones;

        }

    }

}
