/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.demo.overcooked;

import java.util.Random;

/**
 *
 * @author Royvin Arrieta M.
 */
public class Overcooked {

    public static void main(String[] args) {
        Cola cola = new Cola();
        
        
    }
    
    public static String generarOrden(){
        String [] ordenes = {"Hamburguesa de carne(pan,carne)", 
                            "Hamburguesa con queso (pan, carne, queso)", 
                            "Hamburguesa clásica (pan, carne, lechuga, queso)"};
        
        Random random = new Random();
        int indice = random.nextInt(ordenes.length);
        return ordenes[indice];
    }
}
