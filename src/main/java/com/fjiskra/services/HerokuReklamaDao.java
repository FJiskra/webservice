package com.fjiskra.services;

import com.fjiskra.exceptions.DaoException;
import com.fjiskra.model.Reklama;
import com.fjiskra.model.mapper.ReklamaExtractor;
import com.fjiskra.model.mapper.ReklamaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiskra on 14.2.2016.
 */
@Component
public class HerokuReklamaDao {

    @Autowired
    private org.apache.commons.dbcp.BasicDataSource jdbcTemplate;

    @Autowired
    private ReklamaMapper mapper;

    @Autowired
    private ReklamaExtractor extractor;

    public Reklama getRandom() throws DaoException {
        Reklama u = new Reklama();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
             rs = executeQuery("SELECT * FROM ads offset floor(random() * (select count(*) from ads)) LIMIT 1");
            rs.next();
            u = mapper.mapRow(rs, rs.getRow());
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }

        return u;
    }

    public Reklama get(int id) throws DaoException {
        Reklama u = new Reklama();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            rs = executeQuery("SELECT * FROM ads WHERE id = " + id);
            rs.next();
            u = mapper.mapRow(rs, rs.getRow());
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }

        return u;
    }

    public List<Reklama> getAll() throws DaoException {
        List<Reklama> all = new ArrayList<Reklama>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
             rs = executeQuery("SELECT * FROM ads");
            all = extractor.extractData(rs);
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }

        return all;
    }
    private ResultSet executeQuery(String sql) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = jdbcTemplate.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.print(e);
            throw new DaoException(e);
        }finally {
        }

        return rs;
    }
}
