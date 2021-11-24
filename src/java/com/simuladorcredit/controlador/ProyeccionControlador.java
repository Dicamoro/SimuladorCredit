/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simuladorcredit.controlador;

import com.simuladorcredit.modelo.Proyeccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author CAÑON MORENO
 */
@Named(value = "proyeccionControlador")
@SessionScoped  // nivel de alcance
public class ProyeccionControlador implements Serializable {  //implementa una interfaz para poder procesar peticiones http

    /**
     * Creates a new instance of ProyeccionControlador
     */
   
    
@PostConstruct
public void init(){
proyeccion= new Proyeccion();
}
private Proyeccion proyeccion;
    
    private int plazo;
    private double monto;
    private double tasaInteres;

    public ProyeccionControlador(Proyeccion proyeccion, int plazo, double monto) {
        this.proyeccion = proyeccion;
        this.plazo = plazo;
        this.monto = monto;
    }
    
     
    
     public ProyeccionControlador() {
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
   
 public List<Proyeccion> generarProyeccion(){
     proyeccion.calcularCuota(monto, tasaInteres/100, plazo);
     return proyeccion.generarProyeccion(monto, tasaInteres/100, plazo);
 }
 }   

