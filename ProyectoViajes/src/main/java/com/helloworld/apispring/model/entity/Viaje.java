/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

/**
 *
 * @author Jessica Medina
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "publicar_viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Publicar_ViajeGenerator")
    @SequenceGenerator(name = "Publicar_ViajeGenerator", sequenceName = "publicar_viaje_publicar_viaje_id", allocationSize = 1)
    @Column(name = "idreserva")

    private long idreserva;
    @Column(name = "usuario")
    String Usuario;
    
    @Column (name = "puestosReservados")
    String PuestosReservados;
    
    @Column (name = "destino")
    String Destino;
    
    @Column (name = "horaLlegadaOrigen")
    String HoraLlegadaOrigen;
    
    @Column (name = "horaLlegadaDestino")
    String HoraLlegadaDestino;
    
    @Column (name = "reservaViaje")
    String ReservaViaje;
    
    @Column (name = "fechaReserva")
    String FechaReserva;
    
    @Column (name = "horaReserva")
    String HoraReserva;
    
    
      //RELACION 

    public Viaje(long idreserva, String Usuario, String PuestosReservados, String Destino, String HoraLlegadaOrigen, String HoraLlegadaDestino, String ReservaViaje, String FechaReserva, String HoraReserva, Long id) {
        this.idreserva = idreserva;
        this.Usuario = Usuario;
        this.PuestosReservados = PuestosReservados;
        this.Destino = Destino;
        this.HoraLlegadaOrigen = HoraLlegadaOrigen;
        this.HoraLlegadaDestino = HoraLlegadaDestino;
        this.ReservaViaje = ReservaViaje;
        this.FechaReserva = FechaReserva;
        this.HoraReserva = HoraReserva;
        this.id = id;
    }

    public long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(long idreserva) {
        this.idreserva = idreserva;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPuestosReservados() {
        return PuestosReservados;
    }

    public void setPuestosReservados(String PuestosReservados) {
        this.PuestosReservados = PuestosReservados;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getHoraLlegadaOrigen() {
        return HoraLlegadaOrigen;
    }

    public void setHoraLlegadaOrigen(String HoraLlegadaOrigen) {
        this.HoraLlegadaOrigen = HoraLlegadaOrigen;
    }

    public String getHoraLlegadaDestino() {
        return HoraLlegadaDestino;
    }

    public void setHoraLlegadaDestino(String HoraLlegadaDestino) {
        this.HoraLlegadaDestino = HoraLlegadaDestino;
    }

    public String getReservaViaje() {
        return ReservaViaje;
    }

    public void setReservaViaje(String ReservaViaje) {
        this.ReservaViaje = ReservaViaje;
    }

    public String getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(String FechaReserva) {
        this.FechaReserva = FechaReserva;
    }

    public String getHoraReserva() {
        return HoraReserva;
    }

    public void setHoraReserva(String HoraReserva) {
        this.HoraReserva = HoraReserva;
    }

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
