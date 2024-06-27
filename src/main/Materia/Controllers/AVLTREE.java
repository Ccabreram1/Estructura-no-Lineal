package main.Materia.Controllers;

import main.Materia.Models.*;

public class AVLTREE {

    private Node root;

    //OBTENER LA ALTURA DE UN NODE
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight(); //es recursivo
    }

    //METODO QUE OBTENGA EL FACTOR DE BALANCEO O EQUILIBRIO
    // DE UN NODO
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            return node;
        }

        //ACTUALIZAR LA ALTURA DEL PREDECESOR O ANCESTRO
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        //CALCULAR EL BALANCE
        int balance = getBalance(node);
        System.out.println("Se ha insertado el nodo " + value + " con balance " + balance);

        // Si el nodo está desbalanceado se tienen 4 casos 
        //caso izquierda-izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotación derecha en el nodo " + node.getValue() + " con balance " + balance);
            Node newRoot = rightRotate(node);
            System.out.println("Nueva raíz después de la rotación: " + newRoot.getValue());
            return newRoot;
        }

        //caso derecha-derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotación izquierda en el nodo " + node.getValue() + " con balance " + balance);
            Node newRoot = leftRotate(node);
            System.out.println("Nueva raíz después de la rotación: " + newRoot.getValue());
            return newRoot;
        }

        //caso izquierda-derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Rotación izquierda-derecha en el nodo " + node.getValue() + " con balance " + balance);
            node.setLeft(leftRotate(node.getLeft()));
            Node newRoot = rightRotate(node);
            System.out.println("Nueva raíz después de la rotación: " + newRoot.getValue());
            return newRoot;
        }

        //caso derecha-izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Rotación derecha-izquierda en el nodo " + node.getValue() + " con balance " + balance);
            node.setRight(rightRotate(node.getRight()));
            Node newRoot = leftRotate(node);
            System.out.println("Nueva raíz después de la rotación: " + newRoot.getValue());
            return newRoot;
        }

        //devolver el nodo sin cambios o rotaciones
        return node;
    }

    private Node rightRotate(Node nodeR) {
        Node x = nodeR.getLeft();
        Node temp = x.getRight();

        // Realizar la rotación
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // Actualizando las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Devolver nueva raíz
        return x;
    }

    private Node leftRotate(Node nodeR) {
        Node y = nodeR.getRight();
        Node tempo = y.getLeft();

        // Realizar la rotación 
        y.setLeft(nodeR);
        nodeR.setRight(tempo);

        // Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Devolver nueva raíz
        return y;
    }

    public void insert(int value) {
        System.out.println("Nodo a insertar será el " + value);
        root = insert(root, value);
        printTree();
    }

    public void printTree() {
        printTreeNode(root, "", true);
    }

    public void printTreeNode(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }
}
