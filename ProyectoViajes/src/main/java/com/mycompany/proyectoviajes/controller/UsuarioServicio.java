/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoviajes.controller;

import com.helloworld.apispring.model.dao.UsuarioRepositorio;
import com.helloworld.apispring.model.dao.reservaRepositorio;
import com.helloworld.apispring.model.entity.Usuarios;
import com.helloworld.apispring.model.entity.reservaViaje;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jessica Medina
 */
@Service
public class UsuarioServicio {
     @Autowired
    private UsuarioRepositorio UsuarioRepositorio;
     @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public UsuarioServicio() {
        
    }
    
    public List<Usuarios> getAllCrear(){
        return UsuarioRepositorio.getAllUsuarios();
    }
    
}
