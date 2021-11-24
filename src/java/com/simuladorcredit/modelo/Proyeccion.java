/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simuladorcredit.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAÑON MORENO
 */
public class Proyeccion {
    
    private int mes;
    private double saldoInicial;
    private double cuota;
    private double intereses;
    private double capital;
    private double saldoFinal;
    
    //constructores

    public Proyeccion(int mes, double saldoInicial, double cuota, double intereses, double capital, double saldoFinal) {
        this.mes = mes;
        this.saldoInicial = saldoInicial;
        this.cuota = cuota;
        this.intereses = intereses;
        this.capital = capital;
        this.saldoFinal = saldoFinal;
    }

    public Proyeccion() {
    }
    
    //Encapsulamiento

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    
   // metodos
    public void calcularCuota(double monto, double tasaInteres, int plazo){
        this.cuota=monto*(tasaInteres*Math.pow(1+tasaInteres,plazo))
                /(Math.pow(1+tasaInteres, plazo)-1);
    }
    //metodo que permita proyectar toda la tabla de excel
    public List<Proyeccion> generarProyeccion(double monto, double tasaInteres, int plazo){
        List<Proyeccion> lista=new ArrayList<>();
        double auxSaldoFinal=0;
        for (int i=0; i<= plazo; i++){
            
            Proyeccion proyeccion = new Proyeccion();
            proyeccion.mes=i;
            if(i==1)
            proyeccion.saldoInicial=monto;
            else
                proyeccion.saldoInicial=auxSaldoFinal;
            proyeccion.cuota=this.cuota;
            proyeccion.intereses=proyeccion.saldoInicial*tasaInteres;
            proyeccion.capital=proyeccion.cuota-proyeccion.intereses;
            proyeccion.saldoFinal=proyeccion.saldoInicial - proyeccion.capital;
            auxSaldoFinal=proyeccion.saldoFinal;
            
            lista.add(proyeccion);
                  
    }
        return lista; 
}
}