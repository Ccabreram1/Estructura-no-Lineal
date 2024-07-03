package main.Materia.Controllers;
import main.Materia.Models.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
        List <NodeGraph> nodes;

        public Graph(){

            //ArrayList operaciones de insercion y eliminacion es mas rapida
            //funciona con indices.
            this.nodes = new ArrayList<>();
        }

            //metodo para anadir un nodo
        public NodeGraph addNode (int value){
            NodeGraph newNode = new NodeGraph(value);
            nodes.add(newNode);
            return newNode;
            
        }

        //metodo para andir una arista
        public void addEdge(NodeGraph src, NodeGraph dest){
            src.addNeighbor(dest);
            dest.addNeighbor(src); // para grafos no dirigidos

        }

        //metodo para imprimir el grafo
        public void printGraph(){
            for(NodeGraph node : nodes){
                System.out.print("Vertex" + node.getValue() + ":");
                for (NodeGraph neighbor : node.getNeighbors()){
                    System.out.print("-->" + neighbor.getValue() );
                }
                System.out.println();
            }

        }

        //altura
        public void getDFS (NodeGraph starNode){
            boolean[] visited = new boolean[nodes.size()];
            getDFSUtil(starNode, visited);
        }
    
        private void getDFSUtil(NodeGraph node, boolean[] visited) {
            int index = nodes.indexOf(node);
            if (visited[index]) 
            return;
            visited[index] = true;
            System.out.print(node.getValue() + " ");
    
            for (NodeGraph neighbor : node.getNeighbors()) {
                int neighborIndex = nodes.indexOf(neighbor);
                if (!visited[neighborIndex]) {
                    getDFSUtil(neighbor, visited);
                }
            }
            

        }

        //anchura
        public void getBFS (NodeGraph starNode){
             boolean[] visited = new boolean[nodes.size()];
        Queue<NodeGraph> queue = new LinkedList<>();

        visited[nodes.indexOf(starNode)] = true;
        queue.add(starNode);

        while (!queue.isEmpty()) {
            NodeGraph node = queue.poll();
            System.out.print(node.getValue() + " ");

             for (NodeGraph neighbor : node.getNeighbors()) {
                    int neighborIndex = nodes.indexOf(neighbor);
                    if (!visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    queue.add(neighbor);
                    }
                 }   
            }

        }
        
        int [][] getAdjacencyMatrix(){
            int size = nodes.size();
            int[][] adjacencyMatrix = new int[size][size];
    
            for (NodeGraph node : nodes) {
                int rowIndex = nodes.indexOf(node);
                for (NodeGraph neighbor : node.getNeighbors()) {
                    int colIndex = nodes.indexOf(neighbor);
                    adjacencyMatrix[rowIndex][colIndex] = 1; // Si hay una arista
                }
            }
            return adjacencyMatrix;
        }

        public void printAdjancencyMatrix(){
            int[][] matrix = getAdjacencyMatrix();
             for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                     System.out.print(matrix[i][j] + " ");
                }
            System.out.println();
        }

        
    }
    
}
