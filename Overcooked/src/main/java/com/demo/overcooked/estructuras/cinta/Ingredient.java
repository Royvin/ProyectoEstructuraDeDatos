package com.demo.overcooked.estructuras.cinta;

import javax.swing.JPanel;


public class Ingredient {
    private static int Id = 0;
    private int ownId;
    private JPanel ingredient;
    

    public Ingredient(JPanel ingredient) {
        this.ingredient = ingredient;
        this.Id++;
        this.ownId = Id;
    }

    public JPanel getIngredient() {
        return ingredient;
    }

    public void setIngredient(JPanel ingredient) {
        this.ingredient = ingredient;
    }

    public int getId() {
        return this.ownId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
