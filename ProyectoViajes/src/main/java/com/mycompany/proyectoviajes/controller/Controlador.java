/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoviajes.controller;

import com.helloworld.apispring.model.dao.reservaRepositorio;
import com.helloworld.apispring.model.entity.reservaViaje;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge Andrei
 */
@RestController
@RequestMapping("/v1")
public class Controlador {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public ReservaServicio reservaServicio;
    //retorna el valor + el estado (http)

    public Controlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    @RequestMapping(value = "/viaje/", method = RequestMethod.GET)
    public ResponseEntity<List> obtenerViajes() {
        // realiza la llamda
        List<reservaViaje> viaje = reservaServicio.getAllReserva();
        //retorna el valor + el estado (http)
        return new ResponseEntity<List>(viaje, HttpStatus.OK);

    }

    @RequestMapping(value = "/viaje", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<reservaViaje> postAllViaje() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(reservaViaje.class);
        criteria.add(Restrictions.lt("reserva", 1));
        return criteria.list();

    }

//    @RequestMapping(value = "/viaje", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> listarEquipo(@RequestBody reservaViaje reservaViaje) {
//        String resultado = reservaViaje.crearReserva(reservaViaje);
//        return new ResponseEntity<String>(resultado, HttpStatus.OK);
//    }
}
