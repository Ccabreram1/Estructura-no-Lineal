package main.Materia.Controllers;
import java.util.Stack;

import main.Materia.Models.*;

public class ArbolBinario {

             //PRE ORDER

    //RECORRIDO DEL ARBOL TIPO PRE ORDER

    public void preOrderLoop (Node root){
        //VALIDAR QUE NO ESTE VACIO 
        if (root == null) {
            return;
        }
        //crea una pila tipo STACK
        Stack<Node> stack = new Stack<> ();
        //AGG A LA PILA DE LA RAIZ PARA EMPEZAR EL RECORRIDO
         stack.push(root);

         while (!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.print(node.getValue() + "---");

            //AGG LOS HIJOS A LA DERECHA DE LA PILA
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            //AGG LOS HIJOS A LA IZQUIERDA DE LA PILA
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
         }
    }



    //RECURSIVO DEL PRE ORDER
     public void preOrderRecursivo (Node node){
        if (node != null) {
            System.out.print(node.getValue() + "---");
            preOrderRecursivo(node.getLeft());
            preOrderRecursivo(node.getRight());
        }

     }


        ///POST ORDER

     public void postOrderLoop (Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);


            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.getValue() + "--");

            //if (node.getLeft() != null) {
             //   stack2.push(node.getLeft());
            //}
            //if (node.getRight() != null) {
            //    stack2.push(node.getRight());
            //}

        }
     }

     //RECURSIVIDAD 
            //cambia el orden

     public void postOrderRecursivo (Node node){
        if (node != null) {
            postOrderRecursivo(node.getLeft());
            postOrderRecursivo(node.getRight());
            System.out.print(node.getValue() + "--");

        }
     }

        //IN ORDER

      public void inOrderRecursivo (Node node){
        if (node != null) {
            inOrderRecursivo(node.getLeft());
            System.out.print(node.getValue() + "--");
            inOrderRecursivo(node.getRight());
        }
      }


}
