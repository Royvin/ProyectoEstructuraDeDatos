package com.demo.overcooked.estructuras.cinta;

import javax.swing.JPanel;


public class Ingredient {
    private int Id = 0;
    private JPanel ingredient;
    

    public Ingredient(JPanel ingredient) {
        this.ingredient = ingredient;
        this.Id = Id+=1;
    }

    public JPanel getIngredient() {
        return ingredient;
    }

    public void setIngredient(JPanel ingredient) {
        this.ingredient = ingredient;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
