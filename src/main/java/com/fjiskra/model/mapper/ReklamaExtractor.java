package com.fjiskra.model.mapper;

import com.fjiskra.model.Reklama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiskra on 10.3.2016.
 */
@Component
public class ReklamaExtractor implements ResultSetExtractor<List<Reklama>> {

    @Autowired
    ReklamaMapper mapper;

    @Override
    public List<Reklama> extractData(ResultSet rs) throws SQLException,DataAccessException {
        List<Reklama> mapRet= new ArrayList<Reklama>();
        while(rs.next()){
            Reklama r = mapper.mapRow(rs, rs.getRow());
            mapRet.add(r);
        }
        return mapRet;
    }
}
