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
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioGenerator")
    @SequenceGenerator(name = "UsuarioGenerator", sequenceName = "usuario_usuario_id", allocationSize = 1)
    @Column(name = "idusuario")
    private long idusuario;

    @Column(name = "nombre")
    String Nombre;
    @Column(name = "telefono")
    String Telefono;
    @Column(name = "direccion")
    String Direccion;
    @Column(name = "correo")
    String Correo;
    @Column(name = "sesion_idUsuario")
    int sesionidUsuario;
    @Column(name = "ciudad_idciudad")
    int ciudadidciudad;
    // relaciones de la base de datos
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sesion_idUsuario")
    private Usuarios usuarios;
    
    private Usuarios Usuarios;
    
    @Transient
    private Long session;
    
    

    public Usuarios(long idusuario, String Nombre, String Telefono, String Direccion, String Correo, int sesionidUsuario, int ciudadidciudad, Usuarios usuarios, Long session) {
        this.idusuario = idusuario;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.sesionidUsuario = sesionidUsuario;
        this.ciudadidciudad = ciudadidciudad;
        this.usuarios = usuarios;
        this.session = session;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getSesionidUsuario() {
        return sesionidUsuario;
    }

    public void setSesionidUsuario(int sesionidUsuario) {
        this.sesionidUsuario = sesionidUsuario;
    }

    public int getCiudadidciudad() {
        return ciudadidciudad;
    }

    public void setCiudadidciudad(int ciudadidciudad) {
        this.ciudadidciudad = ciudadidciudad;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Long getSession() {
        return session;
    }

    public void setSession(Long session) {
        this.session = session;
    }
    


}
