package com.demo.overcooked.ui;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Transporter {
    private static Transporter instance;
    
    GameScreenUI gameScreen;
    private static Common common = new Common();

    
    public Transporter(){
                this.gameScreen = GameScreenUI.getInstance();

    }
    
    public static Transporter getInstance() {
         if (instance == null) {
            instance = new Transporter();
        }
        return instance;
    }
    
    public void setOpaqueTransporterComponents(){
        Component[] transporterComponents = gameScreen.getContentPane().getComponents();
        
        System.out.println(transporterComponents.length );
        
        for (Component transporterComponent : transporterComponents) {
            if(transporterComponent.getName() == null){
                continue;
            }
            if (transporterComponent.getName().contains("btn")){
                JButton btn = (JButton) transporterComponent;  
                common.setBtnOpaque(btn);

            }else if(transporterComponent.getName().contains("transporter")){
                JPanel panel = (JPanel) transporterComponent;
                panel.setOpaque(false);

            }
            
            
        }
        
    }
}
