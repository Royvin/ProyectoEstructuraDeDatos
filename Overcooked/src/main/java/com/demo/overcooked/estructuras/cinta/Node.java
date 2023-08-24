package com.demo.overcooked.estructuras.cinta;


public class Node {
    private Ingredient dato;
    private Node next;
    
    public Node(Ingredient dato){
        this.dato=dato;
    }

    public Ingredient getDato() {
        return dato;
    }

    public void setDato(Ingredient dato) {
        this.dato = dato;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    

    
    
}
