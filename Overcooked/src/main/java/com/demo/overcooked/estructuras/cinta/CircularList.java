package com.demo.overcooked.estructuras.cinta;


public class CircularList {
    private static CircularList instance;
    private Node head;
    private Node last;
    
    public void inserta(Ingredient p){
            if(head==null){
                head = new Node(p);
                last = head;
            }else if(p.getId()<head.getDato().getId()){
                Node aux = new Node(p);
                aux.setNext(head);
                head=aux;
            }else if(last.getDato().getId() <= p.getId()){
                last.setNext(new Node(p));
                last = last.getNext();
            }else{
               Node aux = head;
               while (aux.getNext().getDato().getId() <p.getId()){
                   aux=aux.getNext();
               }
               Node temp = new Node(p);
               temp.setNext(aux.getNext());
               aux.setNext(temp);
            }
            last.setNext(head);
        } 

    public void elimina (int id) {
            if (head != null) { 
                if (head.getDato().getId() == id) 
                {
                    head = head.getNext();
                } 
                else {
                    Node aux = head; 
                    while (aux.getNext () .getDato () .getId() < id) {
                        aux = aux.getNext () ;
                    }
                    if (aux.getNext () .getDato () .getId () == id) {
                        aux. setNext (aux.getNext () .getNext ());
                    }
                }
            }
        }
    
    public Node getNodehead(){
        return head != null ? head : null;
    }


    public static CircularList getInstance() {
             if (instance == null) {
                instance = new CircularList();
            }
            return instance;
        }

}
