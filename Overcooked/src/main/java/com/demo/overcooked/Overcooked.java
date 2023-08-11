/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.demo.overcooked;

import com.demo.overcooked.ui.MainMenu;
import java.util.Random;

/**
 *
 * @author Royvin Arrieta M.
 */
public class Overcooked {

    public static void main(String[] args) {
     new MainMenu().setVisible(true);
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
