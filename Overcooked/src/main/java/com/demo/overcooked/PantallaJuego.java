/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.demo.overcooked;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author XPC
 */
public class PantallaJuego extends javax.swing.JFrame {
    int segundos=60;
    int segundosOrden=20;
    int minutos=5;
    boolean estado = true;
    boolean estadoTimer=true;
    Cola cola = new Cola();    
    NodoCola nodo = new NodoCola(null);


    /**
     * Creates new form PantallaJuego
     */
    public PantallaJuego() {
        initComponents();
        String root = "C:\\Users\\XPC\\Documents\\1-UNIVERSIDAD\\Estructura de Datos\\ProyectoEstructuraDeDatos\\IMAGENES\\papelOrden.jpg";
        SetImageLabel(lblOrden3, root);
        SetImageLabel(lblOrden2, root);
        SetImageLabel(lblOrden1, root);
        Cronometro();
        TimerNuevaOrden();
        
        // Agregar un ComponentListener para detectar cambios en el tamaño del JFrame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarTamanoComponente();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCronometro = new javax.swing.JLabel();
        lblCuentaRegresiva = new javax.swing.JLabel();
        lblTimerOrden = new javax.swing.JLabel();
        lblOrden2 = new javax.swing.JLabel();
        lblOrden1 = new javax.swing.JLabel();
        lblOrden3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCronometro.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        lblCronometro.setForeground(new java.awt.Color(0, 0, 0));
        lblCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCronometro.setText("5:00");
        jPanel1.add(lblCronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 121, 75));

        lblCuentaRegresiva.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCuentaRegresiva.setForeground(new java.awt.Color(0, 0, 0));
        lblCuentaRegresiva.setText("Tiempo Restante");
        jPanel1.add(lblCuentaRegresiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 121, 21));

        lblTimerOrden.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblTimerOrden.setForeground(new java.awt.Color(0, 0, 0));
        lblTimerOrden.setText("Nueva Orden En: 20");
        jPanel1.add(lblTimerOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 3, 127, -1));
        jPanel1.add(lblOrden2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 150));
        jPanel1.add(lblOrden1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 110, 150));

        lblOrden3.setBackground(new java.awt.Color(255, 255, 255));
        lblOrden3.setForeground(new java.awt.Color(0, 0, 0));
        lblOrden3.setAutoscrolls(true);
        jPanel1.add(lblOrden3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    

    private void ajustarTamanoComponente() {
        // Ajustar el tamaño del JPanel al tamaño actual del JFrame
        jPanel1.setSize(getSize());
        jPanel1.setPreferredSize(getSize());
    }
    public void Cronometro(){
        estado = true;
        this.setLocationRelativeTo(this);
        lblCronometro.setText("5:00");
        Thread hilo = new Thread(){
            public void run(){
                for(;;){
                    if(estado){
                        try{
                            sleep(1000);
                            if(segundos == 0){
                                segundos = 60;
                                minutos--;
                            }else{
                                segundos--;
                            }
                            lblCronometro.setText(minutos + ":" +segundos);
                        }catch(Exception e){

                        }
                    }else{
                        break;

                    }
                }
            }
        };
        hilo.start();
    }
    
    
    
    public void TimerNuevaOrden(){
       estadoTimer = true;
        this.setLocationRelativeTo(this);
        lblTimerOrden.setText("Nueva Orden En: 20");
        Thread hilo = new Thread(){
        public void run(){
            for(;;){
                if(estado){
                    try{
                        sleep(1000);
                        if(segundosOrden == 0){
                            segundosOrden = 20;
                            setNuevaOrden();
                        }
                        
                        else{
                            segundosOrden--;
                        }

                        lblTimerOrden.setText("Nueva Orden En: " +segundosOrden);
                    }catch(Exception e){

                    }
                }else{
                    break;

                }
            }
        }
        };
        setNuevaOrden();
        hilo.start();
    } 
    private void SetImageLabel (JLabel labelName, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance
        (labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    public void setNuevaOrden(){
        Overcooked orden = new Overcooked();
        cola.encola(new NodoCola(new Orden(orden.generarOrden())));
        if(lblOrden1.getText() == null || lblOrden1.getText().length() == 0){
           
        }else if(lblOrden2.getText() == null || lblOrden2.getText().length() == 0){
            
        }else if(lblOrden3.getText() == null || lblOrden3.getText().length() == 0){
            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCronometro;
    private javax.swing.JLabel lblCuentaRegresiva;
    private javax.swing.JLabel lblOrden1;
    private javax.swing.JLabel lblOrden2;
    private javax.swing.JLabel lblOrden3;
    private javax.swing.JLabel lblTimerOrden;
    // End of variables declaration//GEN-END:variables
}
