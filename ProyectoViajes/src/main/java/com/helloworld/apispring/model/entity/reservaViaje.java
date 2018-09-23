/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jorge Andrei
 */
@Entity
@Table(name="reserva_viaje")
public class reservaViaje {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservaviajeGenerator")
    @SequenceGenerator(name = "reservaviajeGenerator", sequenceName = "reservaviaje_reservaviaje_id", allocationSize = 1)
    @Column(name = "idreserva_viaje")
     
   
    private long idreservaviaje;
     @Column
    private Integer reserva;
     @Column(name = "puestosReservados")
    String puestosreservados;
     @Column(name = "destino")
    String Destino;
     @Column(name = "horaLLegadaOrigen")
    String HoraLLegadaOrigen;
     @Column(name = "horaLLegadaDestino")
    String HoraLLegadaDestino;
     @Column(name = "fechaReserva")
    String FechaReserva;
     @Column(name = "horaReserva")
    String horaReserva;
     @Column(name = "usuarios_idusuarios")
    int usuarios_idusuarios;
     
//     @Column(name = "ciudad_idciudad")
//    int ciudadIdciudad;
     
     
      @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarios_idusuarios")
     
    private reservaViaje reservaViaje;
       
    @Transient
    private Long Usuarios;

    public reservaViaje(long idreservaviaje, String puestosreservados, String Destino, String HoraLLegadaOrigen, String HoraLLegadaDestino, String FechaReserva, String horaReserva, int usuarios_idusuarios, int ciudadIdciudad, reservaViaje reservaViaje, Long Usuarios) {
        this.idreservaviaje = idreservaviaje;
        this.puestosreservados = puestosreservados;
        this.Destino = Destino;
        this.HoraLLegadaOrigen = HoraLLegadaOrigen;
        this.HoraLLegadaDestino = HoraLLegadaDestino;
        this.FechaReserva = FechaReserva;
        this.horaReserva = horaReserva;
        this.usuarios_idusuarios = usuarios_idusuarios;
//        this.ciudadIdciudad = ciudadIdciudad;
        this.reservaViaje = reservaViaje;
        this.Usuarios = Usuarios;
    }

    public long getIdreservaviaje() {
        return idreservaviaje;
    }

    public void setIdreservaviaje(long idreservaviaje) {
        this.idreservaviaje = idreservaviaje;
    }

    public String getPuestosreservados() {
        return puestosreservados;
    }

    public void setPuestosreservados(String puestosreservados) {
        this.puestosreservados = puestosreservados;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getHoraLLegadaOrigen() {
        return HoraLLegadaOrigen;
    }

    public void setHoraLLegadaOrigen(String HoraLLegadaOrigen) {
        this.HoraLLegadaOrigen = HoraLLegadaOrigen;
    }

    public String getHoraLLegadaDestino() {
        return HoraLLegadaDestino;
    }

    public void setHoraLLegadaDestino(String HoraLLegadaDestino) {
        this.HoraLLegadaDestino = HoraLLegadaDestino;
    }

    public String getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(String FechaReserva) {
        this.FechaReserva = FechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }

//    public int getCiudadIdciudad() {
//        return ciudadIdciudad;
//    }
//
//    public void setCiudadIdciudad(int ciudadIdciudad) {
//        this.ciudadIdciudad = ciudadIdciudad;
//    }

    public reservaViaje getReservaViaje() {
        return reservaViaje;
    }

    public void setReservaViaje(reservaViaje reservaViaje) {
        this.reservaViaje = reservaViaje;
    }

    public Long getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Long Usuarios) {
        this.Usuarios = Usuarios;
    }
    
     
}
