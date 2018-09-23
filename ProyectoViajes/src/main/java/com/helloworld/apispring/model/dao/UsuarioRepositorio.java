/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Usuarios;
import com.helloworld.apispring.model.entity.reservaViaje;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jessica Medina
 */
public class UsuarioRepositorio {
     @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
     //LISTA LAS RESERVAS
    public List<Usuarios> getAllUsuarios() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        criteria.add(Restrictions.lt("usuarios", 10));
        return criteria.list();
    }
    
    
}
