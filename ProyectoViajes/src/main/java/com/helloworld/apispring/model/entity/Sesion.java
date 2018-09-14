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
@Table(name="sesion")
public class Sesion {
   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SesionGenerator")
    @SequenceGenerator(name = "SesionGenerator", sequenceName = "sesion_sesion_id", allocationSize = 1)
    @Column(name = "idSesion") 
   
     private long idSesion;
   @Column(name = "password")
    String password; 
   @Column(name = "registrarse")
    String Registrarse;
   @Column(name = "usuarios_idusuario")
    int usuariosidusuario;  
   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sesion_idUsuario")
    private Sesion sesion;
    @Transient
    private Long Usuarios;
    
    
}
