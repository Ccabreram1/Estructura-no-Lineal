package main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeGraph {
    
    private int value;
    private List<NodeGraph> neighbors;

    public NodeGraph (int value){
        this.value = value;
        this.neighbors = new LinkedList<>();
        //Linkedlist operacionde de insercion  es mas lenta
    }

    public int getValue(){
        return value;
    }
    public List<NodeGraph> getNeighbors() {
        return neighbors;
    }
    public void addNeighbor(NodeGraph neighbor) {
        neighbors.add(neighbor);
    }

    
    








}
