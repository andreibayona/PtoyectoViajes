/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.reservaViaje;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.hibernate.criterion.Restrictions;
import static org.hibernate.internal.CoreLogging.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import static org.hibernate.internal.CoreLogging.logger;
import static org.hibernate.internal.CoreLogging.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jessica Medina
 */
@Repository
@Transactional
public class reservaRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     //LISTA LAS RESERVAS
    public List<reservaViaje> getAllViajes() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(reservaViaje.class);
        criteria.add(Restrictions.lt("reserva", 10));
        return criteria.list();
    }
     // CREA RESERVA
    public long crearReserva(reservaViaje reserv) {
        getSessionFactory().getCurrentSession().save(reserv);
        return reserv.getIdreservaviaje();
    }

    //actualizar reserva
    public String updateViaje(reservaViaje reser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(reser);
        return "Actualizar Viaje:" +session;

    }

    //eliinar reserv_Viaje
    public String removeViaje(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		reservaViaje v = (reservaViaje) session.load(reservaViaje.class, new Integer(id));
		if(null != v){
			session.delete(v);
		}
		return "Elimina Viaje:" +session;
	}

}
