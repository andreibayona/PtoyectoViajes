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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jorge Andrei
 */
@Entity
@Table(name = "tipo_marca")
public class tipoMarca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoMarcaGenerator")
    @SequenceGenerator(name = "TipoMarcaGenerator", sequenceName = "idmarca", allocationSize = 1)
    @Column(name = "idmarca")
    private long idMarca;
    @Column(name = "nombre")
    String Nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmarca")
    private tipoMarca tipomarca;
    @Transient
    private Long caracteristicas_carro;

    public tipoMarca(long idMarca, String Nombre, tipoMarca tipomarca, Long caracteristicas_carro) {
        this.idMarca = idMarca;
        this.Nombre = Nombre;
        this.tipomarca = tipomarca;
        this.caracteristicas_carro = caracteristicas_carro;
    }

    public long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public tipoMarca getTipomarca() {
        return tipomarca;
    }

    public void setTipomarca(tipoMarca tipomarca) {
        this.tipomarca = tipomarca;
    }

    public Long getCaracteristicas_carro() {
        return caracteristicas_carro;
    }

    public void setCaracteristicas_carro(Long caracteristicas_carro) {
        this.caracteristicas_carro = caracteristicas_carro;
    }
    
}
