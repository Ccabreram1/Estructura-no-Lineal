package main.Materia.Controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    //lenght=  es un atributo(porque tienen tamano fijo)
    //size = es un metodo pero en arreglos 



    public Sets (){
        construirHashSet();
        construirLinkedHashSet();
        construirTreeSet();
        construirTreeSetConComparador();
    }

    //construir y mostrar un HashSet
    public void construirHashSet(){
        //INTANCIA conjunto 
        //x detras de la clase de objeto debe a ver una clase abstracta
    HashSet<String> conjunto = new HashSet<>();
    conjunto.add("Manzana");
    conjunto.add("Banana");
    conjunto.add("Naranja");
    conjunto.add("Manzana"); //duplicado, no se anadira
    conjunto.add("Uvas");
    conjunto.add("Pina");
    System.out.println("\nContruir HashSet");
    System.out.println("HashSet: " + conjunto);

    //eliminar un elemento
    conjunto.remove("Banana");
    System.out.println("HashSet despues de eliminar "+ conjunto);
    conjunto.remove("Pina");
    System.out.println("HashSet despues de eliminar "+ conjunto);

    //verificar si un elemento existe
    Boolean contieneNaranja = conjunto.contains("Naranja");
    System.out.println("HashSet contiene Naranja? " + contieneNaranja);

    //obtener el tamano del conjunto
    int tamano = conjunto.size();
    System.out.println("Tamano del HashSet: " + tamano);

    }

    //construir y mostrar un LinkedHashSet
    public void construirLinkedHashSet(){
        LinkedHashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //duplicado, no se anadira
        conjunto.add("Uvas");
        conjunto.add("Pina");
        //agg elementos en la forma que escribimos, no altera el orden
        System.out.println("\nContruir LinkedHashSet");
        System.out.println("LinkedHashSet: " + conjunto);

    }

    //construir y mostrar un TreeSet con orden natural
    public void construirTreeSet(){
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //duplicado, no se anadira
        conjunto.add("Uvas");
        conjunto.add("Pina");
        //agg elementos en orden alfabetico en INORDER DE MENOR A MAYOR ASCEN.
        //raiz Manzana
        System.out.println("\nContruir TreeSet");
        System.out.println("TreeSet: " + conjunto);


    }

    public void construirTreeSetConComparador(){
        Comparator<String> comparadorOrdenInverso = new Comparator<String>(){
            @Override
            public int compare (String o1, String o2){
                return o2.compareTo(o1);
            }
        };
        TreeSet<String> conjunto = new TreeSet<>(comparadorOrdenInverso);
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana"); //duplicado, no se anadira
        conjunto.add("Uvas");
        conjunto.add("Pina");
        System.out.println("\nContruir TreeSet Con Comparador");
        System.out.println("Tree Set Con Comparador: " + conjunto);
    }



    
}
