package com.demo.overcooked.ui;

import com.demo.overcooked.ui.orders.main.BigCheeseBurger;
import com.demo.overcooked.ui.orders.main.BigCheeseMeatBurger;
import com.demo.overcooked.ui.orders.main.BigMeatBurger;
import com.demo.overcooked.ui.orders.tiny.TinyCheeseBurger;
import com.demo.overcooked.ui.orders.tiny.TinyCheeseMeatBurger;
import com.demo.overcooked.ui.orders.tiny.TinyMeatBurger;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIMethods {
    
    private Constants constants = new Constants();

    public void setBackgroundImage(JLabel label, String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        label.setIcon(image);
    }

    public JPanel getRandomOrder(){
        JPanel[] orders = {
            new TinyCheeseBurger(),
            new TinyMeatBurger(),
            new TinyCheeseMeatBurger()
        };
        
        orders[0].setName(constants.CHEESE_BURGER());
        orders[1].setName(constants.MEAT_BURGER());
        orders[2].setName(constants.MEAT_AND_CHEESE_BURGER());

        int randomIndex = new Random().nextInt(orders.length);
        
        return orders[randomIndex];
    }
    
    public JPanel getMainOrderPanel(String orderName){
        if(orderName == constants.MEAT_AND_CHEESE_BURGER()){
            return new BigCheeseMeatBurger();
        }else if(orderName  == constants.CHEESE_BURGER()){
            return new BigCheeseBurger();    
        }
        
        return new BigMeatBurger();
    }
}
