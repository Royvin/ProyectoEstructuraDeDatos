/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.overcooked;

/**
 *
 * @author Royvin Arrieta M.
 */
public class Cola {
    private NodoCola frente;
    private NodoCola ultimo;
    private int largo;
    
    
    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }
    
    public void encola(NodoCola nuevoNodo){
        if(frente == null){
            frente = nuevoNodo;
            ultimo = nuevoNodo;                    
        } else{
            ultimo.setAtras(nuevoNodo);
            ultimo=nuevoNodo;
        }
        largo++;
    }
    
    public NodoCola atiende(){
        NodoCola aux = frente;
        if(frente!=null){
            frente=frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }
    
    public String imprimir(){
        String mensaje="";
        NodoCola aux=frente;
        while(aux!=null){
            mensaje+=aux.getDato().getOrden()+ "\n";
            aux=aux.getAtras();
        }
        return mensaje;
    }
    
    public String getOrden1(){
        String mensaje="";
        mensaje=frente.getDato().getOrden();
        return mensaje;
    }
    public String getOrden2(){
        String mensaje="";
        NodoCola aux=frente;
        aux.getAtras();
        mensaje=aux.getDato().getOrden();
        return mensaje;
    }
    public String getOrden3(){
        String mensaje="";
        mensaje=ultimo.getDato().getOrden();
        return mensaje;
    }
    
}
