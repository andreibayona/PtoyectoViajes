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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import static org.hibernate.engine.internal.Cascade.cascade;

/**
 *
 * @author Jessica Medina
 */
@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CiudadGenerator")
    @SequenceGenerator(name = "CiudadGenerator", sequenceName = "ciudad_ciudad_id", allocationSize = 1)
    @Column(name = "idciudad")
    private long idciudad;

    @Column(name = "nombre")
    String nombre;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idciudad" )
    private Ciudad ciudad;
     @Transient
     private long reserva_viaje;
     
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idciudad" )
    private Ciudad ciudadd;
     @Transient
     private long Usuarios;
     
     @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idciudad" )
    private Ciudad ciudaddd;
     @Transient
     private long Publicar_Viaje;

    public Ciudad(long idciudad, String nombre, Ciudad ciudad, long reserva_viaje, Ciudad ciudadd, long Usuarios, Ciudad ciudaddd, long Publicar_Viaje, Long id) {
        this.idciudad = idciudad;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.reserva_viaje = reserva_viaje;
        this.ciudadd = ciudadd;
        this.Usuarios = Usuarios;
        this.ciudaddd = ciudaddd;
        this.Publicar_Viaje = Publicar_Viaje;
        this.id = id;
    }

    public long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(long idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public long getReserva_viaje() {
        return reserva_viaje;
    }

    public void setReserva_viaje(long reserva_viaje) {
        this.reserva_viaje = reserva_viaje;
    }

    public Ciudad getCiudadd() {
        return ciudadd;
    }

    public void setCiudadd(Ciudad ciudadd) {
        this.ciudadd = ciudadd;
    }

    public long getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(long Usuarios) {
        this.Usuarios = Usuarios;
    }

    public Ciudad getCiudaddd() {
        return ciudaddd;
    }

    public void setCiudaddd(Ciudad ciudaddd) {
        this.ciudaddd = ciudaddd;
    }

    public long getPublicar_Viaje() {
        return Publicar_Viaje;
    }

    public void setPublicar_Viaje(long Publicar_Viaje) {
        this.Publicar_Viaje = Publicar_Viaje;
    }
    
 
    // relacion con las tablas muchos a uno reserva_viaje y ciudad
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
