package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBST {

    public Node insert(Node root, int value) {
        //throw new UnsupportedOperationException("Unimplemented method 'insert'");


        //Node(5)
        //insert(Node(5),3)

        if (root ==null) {
            return new Node(value); //1= REGRESA UN NODO CON VALOR 5
        }

        if (value < root.getValue()) {
            //root.setLeft(root.getLeft(), value);
            root.setLeft(insert(root.getLeft(), value));
        }else if(value >root.getValue()){
            root.setRight(insert(root.getRight(),value));
        }
        return root;

    
    }

}
