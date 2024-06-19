package Lmain;

import Lmain.LMateria.Controllers.ArbolBinario;
import Lmain.LMateria.LModels.LNode;

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
        LNode nodeRoot = new LNode(1);

        //DEL PADRE PONER LOS HIJOS 2 Y 3 (IZQ, DER)
        nodeRoot.setLeft(new LNode(2));
        nodeRoot.setRight(new LNode(3));

        //AGG AL HIJO DEL HIJO 
              //DEL 2 SALE 4 Y 5
              //VOY A LA RAIZ  Y OBTENGO LA INSRANCIA DEL DOS Y NUEVO INSTACIO OTRO NODO
        nodeRoot.getLeft().setLeft(new LNode(4));
        nodeRoot.getLeft().setRight(new LNode(5));

        nodeRoot.getRight().setRight(new LNode(6));

        nodeRoot.getLeft().getLeft().setLeft(new LNode(7));
        nodeRoot.getLeft().getRight().setLeft(new LNode(8));


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







        







    }
}
