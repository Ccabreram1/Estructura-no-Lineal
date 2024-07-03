package main;

import main.Materia.Controllers.AVLTREE;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.Graph;
import main.Materia.Controllers.Sets;
import main.Materia.Models.Node;
import main.Materia.Models.NodeGraph;

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

       
        runGraph();
    }


    private static void runGraph() {
        Graph grap = new Graph();

        //agg nodos 
        //NodeGraph node1 = new NodeGraph(1);
        // NodeGraph node2 = new NodeGraph(2);
        //NodeGraph node3 = new NodeGraph(3);
        //NodeGraph node4 = new NodeGraph(4);
        //NodeGraph node5 = new NodeGraph(5);

        NodeGraph node1 = grap.addNode(1);
        NodeGraph node2 = grap.addNode(2);
        NodeGraph node3 = grap.addNode(3);
        NodeGraph node4 = grap.addNode(4);
        NodeGraph node5 = grap.addNode(5);

        grap.addEdge(node1, node2);
        grap.addEdge(node2, node4);
        grap.addEdge(node1, node3);
        grap.addEdge(node4, node5);

        //imprime el grafo
        grap.printGraph();

        runSets();
    }

    private static void runSets(){
        Sets variableClase = new Sets();
    }








}
