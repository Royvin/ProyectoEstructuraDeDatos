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
        PantallaInicio inicio = new PantallaInicio();
        inicio.setVisible(true);     
    }
    
    public static String generarOrden(){
        String [] ordenes = {"Hamburguesa \nde carne(\npan,\ncarne)", 
                            "Hamburguesa \ncon queso (\npan, \ncarne, \nqueso)", 
                            "Hamburguesa\n clásica (\npan, \ncarne, \nlechuga, \nqueso)"};
        
        Random random = new Random();
        int indice = random.nextInt(ordenes.length);
        return ordenes[indice];
    }
}
