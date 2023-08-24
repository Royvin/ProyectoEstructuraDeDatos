/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.overcooked.estructuras.ordenes;

import javax.swing.JPanel;

/**
 *
 * @author Royvin Arrieta M.
 */
public class Cola {
    
    private static Cola instance;
    private NodoCola frente;
    private NodoCola ultimo;
    private int largo;

    private Cola() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }

    public void encola(NodoCola nuevoNodo) {
        if (frente == null) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setAtras(nuevoNodo);
            ultimo = nuevoNodo;
        }
        largo++;
    }

    public void desencola() {
        if (frente != null) {
            frente = frente.getAtras();
            largo--;
        }
    }
    
    public NodoCola getNodoFrente(){
        return frente != null ? frente : null;
    }

    public JPanel getFrente() {
        return frente != null ? frente.getDato().getOrden() : null;
    }

    public JPanel getUltimo() {
        return ultimo.getDato().getOrden();
    }

    public static Cola getInstance() {
         if (instance == null) {
            instance = new Cola();
        }
        return instance;
    }
    
    public String imprimir() {
        String mensaje = "";
        NodoCola aux = frente;
        while (aux != null) {
            mensaje += aux.getDato().getOrden() + "\n";
            aux = aux.getAtras();
        }
        return mensaje;
    }
}
