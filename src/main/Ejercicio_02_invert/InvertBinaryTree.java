package main.Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {

    public Node invertTree(Node root) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'invertTree'");
            
        if (root ==null) {
            return null; //1= REGRESA UN NODO CON VALOR 5
        }

        Node left = invertTree(root.getLeft());
        Node right = invertTree(root.getRight());

        root.setLeft(right);
        root.setRight(left);


        return root;

    }
    
}
