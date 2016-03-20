package com.fjiskra.model.controller;

import com.fjiskra.exceptions.DaoException;
import com.fjiskra.model.Reklama;
import com.fjiskra.services.HerokuReklamaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiskra on 14.2.2016.
 */
@RestController
@RequestMapping(value = "/api/v1/ads")
public class ReklamaController {

    @Autowired
    private HerokuReklamaDao reklamaDao;

    @RequestMapping(value = "/random")
    @ResponseBody
    public ResponseEntity<Reklama> getRandomAd() {
        Reklama u;
        try {
            u = reklamaDao.getRandom();
        } catch (DaoException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Reklama>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Reklama> getAd(@PathVariable("id") int id) {
        Reklama u = null;
        try {
            u = reklamaDao.get(id);
        } catch (DaoException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (u == null) {
            return new ResponseEntity<Reklama>(u, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Reklama>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<Reklama>> getAllAds() {
        List<Reklama> allAds = null;

        try {
            allAds = reklamaDao.getAll();
        } catch (DaoException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Reklama>>(allAds, HttpStatus.OK);
    }
}
