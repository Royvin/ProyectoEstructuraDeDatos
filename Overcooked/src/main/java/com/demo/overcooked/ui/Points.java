package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.ordenes.Cola;


public class Points {
    private static Points instance;
    int meatBurgerPoints = 5;
    int cheeseBurgerPoints = 10;
    int ClassicBurguerPoints = 15;
    int totalPoints = 0;
    
    GameScreenUI gameScreen;
    private static Constants constant = new Constants();

    
    public Points(){
        gameScreen = GameScreenUI.getInstance();
    }
          
    public void pointsSystem(){
        String currentOrderName = Cola.getInstance().getFrente().getName();
        
        this.gameScreen.getPointsLabel().setText("0pts");
        if (currentOrderName == constant.MEAT_AND_CHEESE_BURGER) {
            totalPoints+=ClassicBurguerPoints;
        } else if (currentOrderName == constant.CHEESE_BURGER) {
            totalPoints+=cheeseBurgerPoints;
        } else if(currentOrderName == constant.MEAT_BURGER){
            totalPoints+=meatBurgerPoints;
        }
        this.gameScreen.getPointsLabel().setText(totalPoints+"pts");
    }
    
      public static Points getInstance() {
        if (instance == null) {
            instance = new Points();
        }
        return instance;
    }
}
