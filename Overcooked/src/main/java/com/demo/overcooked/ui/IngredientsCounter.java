package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.ordenes.Cola;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IngredientsCounter {

    private Common common = new Common();
    private Constants constant = new Constants();
    private static IngredientsCounter instance;

    int totalIngredientsNeeded = 0;
    int ingredientsReady = 0;
    String ingredientAdded = "";
    JLabel ingredientCounter;

    private IngredientsCounter() {
    }

    public boolean allIngredientsAreInOrder() {
        boolean allIngredientsReady = false;
        
        if(ingredientsReady == 0){
            allIngredientsReady =  false;
        }else if (totalIngredientsNeeded == ingredientsReady){
            totalIngredientsNeeded = 0;
            ingredientsReady = 0;
            ingredientCounter.setText("");
            
            allIngredientsReady =  true;
        }
        
        return allIngredientsReady;
    }

    public void updateIngredientsCounter(String ingredientToAdd) {
        if (ingredientAdded.equals(ingredientToAdd)) {
            return;
        }

        totalIngredientsNeeded = getTotalIngredientsFromGivenOrder(
                Orders.getInstance().getCurrentMainOrderName()
        );

        if (ingredientsReady == totalIngredientsNeeded) {
            return;
        }

        JPanel currentMainOrder
                = Orders.getInstance().getCurrentMainOrderPanel();
        ingredientCounter = (JLabel) common.getComponents(
                currentMainOrder,
                "label"
        )[0];

        ingredientsReady++;
        ingredientAdded = ingredientToAdd;

        String text = String.format(
                "(%d/%d)",
                ingredientsReady,
                totalIngredientsNeeded
        );
        ingredientCounter.setText(text);
    }

    public boolean isIngredientPartOfOrder(String ingredientToCheck) {
        String orderName = Cola.getInstance().getFrente().getName();
        boolean isIngredientPresent = false;

        if (orderName.equals(constant.CHEESE_BURGER)) {
            isIngredientPresent
                    = Arrays.stream(
                            constant.CHEESE_BURGER_INGREDIENTS)
                            .anyMatch(ingredient -> ingredient == ingredientToCheck);
        } else if (orderName.equals(constant.MEAT_BURGER)) {
            isIngredientPresent
                    = Arrays.stream(
                            constant.MEAT_BURGER_INGREDIENTS)
                            .anyMatch(ingredient -> ingredient == ingredientToCheck);
        } else {
            isIngredientPresent
                    = Arrays.stream(
                            constant.CHEESE_AND_MEAT_BURGER_INGREDIENTS)
                            .anyMatch(ingredient -> ingredient == ingredientToCheck);
        }

        return isIngredientPresent;
    }

    private int getTotalIngredientsFromGivenOrder(String orderName) {
        if (orderName.equals(constant.MEAT_AND_CHEESE_BURGER)) {
            return 4;
        }

        return 2;
    }

    public static IngredientsCounter getInstance() {
        if (instance == null) {
            instance = new IngredientsCounter();
        }
        return instance;
    }
}
