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
public class Orden {
    private JPanel orden;
    

    public Orden(JPanel orden) {
        this.orden = orden;
    }

    public JPanel getOrden() {
        return orden;
    }

    public void setOrden(JPanel orden) {
        this.orden = orden;
    } 
}
