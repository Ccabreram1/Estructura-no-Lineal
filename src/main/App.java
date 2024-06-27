package main;

import main.Materia.Controllers.AVLTREE;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         *                    1
         *              2           3                   
         *          4      5           6
         *      7        8 
         */    

        ArbolBinario arbolBinario = new ArbolBinario();

        //PADRE ES 1
        Node nodeRoot = new Node(1);

        //DEL PADRE PONER LOS HIJOS 2 Y 3 (IZQ, DER)
        nodeRoot.setLeft(new Node(2));
        nodeRoot.setRight(new Node(3));

        //AGG AL HIJO DEL HIJO 
              //DEL 2 SALE 4 Y 5
              //VOY A LA RAIZ  Y OBTENGO LA INSRANCIA DEL DOS Y NUEVO INSTACIO OTRO NODO
        nodeRoot.getLeft().setLeft(new Node(4));
        nodeRoot.getLeft().setRight(new Node(5));

        nodeRoot.getRight().setRight(new Node(6));

        nodeRoot.getLeft().getLeft().setLeft(new Node(7));
        nodeRoot.getLeft().getRight().setLeft(new Node(8));


        //PRE ORDER
        
        //TIENE QUE IMPRIMIR 1-2-4-7-5-8-3-6
        System.out.println("ARBOL BINARIO PREORDER");
        arbolBinario.preOrderLoop(nodeRoot);

        System.out.println("\nARBOL BINARIO RECURSIVO PREORDER");
        arbolBinario.preOrderRecursivo(nodeRoot);

        //POST ORDER

        System.out.println("\nARBOL BINARIO POSTORDER");
        arbolBinario.postOrderLoop(nodeRoot);
        System.out.println("\nARBOL BINARIO RECURSIVO POSTORDER");
        arbolBinario.postOrderRecursivo(nodeRoot);

        //IN ORDER

        System.out.println("\nARBOL BINARIO INORDER RECURSIVO");
        arbolBinario.inOrderRecursivo(nodeRoot);


        AVLTREE tree = new AVLTREE();

        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            tree.insert(value);
        }


        


    }
}
