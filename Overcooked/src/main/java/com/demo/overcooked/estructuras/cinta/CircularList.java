package com.demo.overcooked.estructuras.cinta;

import javax.swing.JPanel;

public class CircularList {

    private static CircularList instance;
    private Node head;
    private Node last;
    private int size;

    public void inserta(Ingredient p) {
        if (head == null) {
            head = new Node(p);
            last = head;
        } else if (p.getId() < head.getDato().getId()) {
            Node aux = new Node(p);
            aux.setNext(head);
            head = aux;
        } else if (last.getDato().getId() <= p.getId()) {
            last.setNext(new Node(p));
            last = last.getNext();
        } else {
            Node aux = head;
            while (aux.getNext().getDato().getId() < p.getId()) {
                aux = aux.getNext();
            }
            Node temp = new Node(p);
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }
        size++;
    }

    public void elimina(JPanel ingredient) {
        if (head != null) {
            if (head.getDato().getIngredient() == ingredient) {
                //System.out.println("head" + head.getDato().getId() + head.getDato().getIngredient().getName());
                head = head.getNext();
            } else {
                Node aux = head;
                while (aux.getNext().getDato().getIngredient() != ingredient) {
                    aux = aux.getNext();
                    //System.out.println(aux.getNext().getDato().getId());
                }
                if (aux.getNext().getDato().getIngredient() == ingredient) {
                    //System.out.println("found" + aux.getNext().getDato().getId()  + aux.getNext().getDato().getIngredient().getName());
                    aux.setNext(aux.getNext().getNext());

                }
            }
        }
        size--;
    }

    public JPanel getHeadPanel() {
        return head != null ? head.getDato().getIngredient() : null;
    }
    
    public Node getHeadNode() {
        return head != null ? head : null;
    }

    public Node getLast() {
        return last != null ? last : null;
    }
    
    
    public int getSize(){
        return this.size;
    }

    public static CircularList getInstance() {
        if (instance == null) {
            instance = new CircularList();
        }
        return instance;
    }

}
