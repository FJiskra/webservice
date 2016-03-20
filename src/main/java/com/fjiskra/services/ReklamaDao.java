package com.fjiskra.services;

import com.fjiskra.exceptions.DaoException;
import com.fjiskra.model.Reklama;
import com.fjiskra.model.mapper.ReklamaExtractor;
import com.fjiskra.model.mapper.ReklamaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiskra on 14.2.2016.
 */
@Component
public class ReklamaDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private ReklamaMapper mapper;
//    @Autowired
//    private ReklamaExtractor extractor;
//
//    public Reklama getRandom() throws DaoException {
//        Reklama u = new Reklama();
//        try {
//            u = (Reklama) jdbcTemplate.queryForObject("SELECT * FROM ads ORDER BY RAND() LIMIT 1", mapper);
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//
//        return u;
//    }
//
//    public Reklama get(int id) throws DaoException {
//        Reklama u = new Reklama();
//        try {
//            u = (Reklama) jdbcTemplate.queryForObject("SELECT * FROM ads WHERE id = " + id, mapper);
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//
//        return u;
//    }
//    public List<Reklama> getAll() throws DaoException {
//        List<Reklama> all = new ArrayList<Reklama>();
//
//        try {
//
//            all = jdbcTemplate.query("SELECT * FROM ads", extractor);
//
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//
//        return all;
//    }
}
