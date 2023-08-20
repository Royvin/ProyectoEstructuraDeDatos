package com.demo.overcooked.ui;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Timers {
    int segundos = 60;
    int minutos = 4;
    int segundosOrden = 2;
    
    private GameScreenUI gameScreen;
    
    public Timers(){
        gameScreen = GameScreenUI.getInstance();
        gameScreen.setVisible(true);
    }
    
    private void gameTimer() {
        JLabel timerLabel = this.gameScreen.getTimerLabel();
        timerLabel.setText("5:00");

        Thread hilo = new Thread() {
            public void run() {

                while (true) {
                    try {
                        sleep(1000);
                        if (segundos == 0) {
                            segundos = 60;
                            minutos--;
                        } else {
                            segundos--;
                        }
                        timerLabel.setText(minutos + ":" + segundos);
                    } catch (Exception e) {
                    }
                }
            }
        };

        hilo.start();
    }

    private void timerNewOrder() {
        Thread hilo = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        if (segundosOrden == 0) {
                            segundosOrden = 2;
                            SwingUtilities.invokeLater(() -> {
                                Orders.getInstance().addNewOrder();
                            });

                        } else {
                            segundosOrden--;
                        }

                    } catch (Exception e) {

                    }
                }
            }
        };
        hilo.start();
    }
    
    public void initTimers(){
        gameTimer();
        timerNewOrder();
    }
    
}
