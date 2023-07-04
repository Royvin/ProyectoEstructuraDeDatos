/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.overcooked;

/**
 *
 * @author Royvin Arrieta M
 */
public class NodoCola {
    private Orden Dato;
    private NodoCola Atras;

    public NodoCola(Orden Dato) {
        this.Dato = Dato;
        this.Atras = null;
    }

    public Orden getDato() {
        return Dato;
    }

    public void setDato(Orden Dato) {
        this.Dato = Dato;
    }

    public NodoCola getAtras() {
        return Atras;
    }

    public void setAtras(NodoCola Atras) {
        this.Atras = Atras;
    }
    
    
    
    
}
