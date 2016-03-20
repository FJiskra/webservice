package com.fjiskra.model.mapper;

import com.fjiskra.model.Reklama;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jiskra on 14.2.2016.
 */
@Component
public class ReklamaMapper implements RowMapper<Reklama>, ResultSetExtractor<List<Reklama>> {

    @Override
    public Reklama mapRow(ResultSet resultSet, int i) throws SQLException {
        Reklama u = new Reklama();
        u.id = resultSet.getInt("id");
        u.html = resultSet.getString("html");
        return u;
    }

    @Override
    public List<Reklama> extractData(ResultSet rs) throws SQLException,DataAccessException {
        List<Reklama> mapRet= new ArrayList<Reklama>();
        while(rs.next()){
            Reklama r = mapRow(rs, rs.getRow());
            mapRet.add(r);
        }
        return mapRet;
    }
}
