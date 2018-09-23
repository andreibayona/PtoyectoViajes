/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoviajes.controller;


import com.helloworld.apispring.model.dao.reservaRepositorio;
import com.helloworld.apispring.model.entity.reservaViaje;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jessica Medina
 */
@Service
public class ReservaServicio {
    
    @Autowired
    private reservaRepositorio reservaRepositorio;
     @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public ReservaServicio() {
        
    }
    
    public List<reservaViaje> getAllReserva(){
        return reservaRepositorio.getAllViajes();
    }

   public String crearReserva(reservaViaje reserv) {
    long reservaId= reservaRepositorio.crearReserva(reserv);
    return "Reserva Creada con ID:"+reservaId;
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
