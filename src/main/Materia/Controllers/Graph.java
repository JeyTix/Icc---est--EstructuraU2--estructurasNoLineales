package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.List;
import main.Materia.Models.NodeG;


public class Graph {
private List<NodeG> nodes = new ArrayList<>();

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeG addNode(int value){
        NodeG nodeG=new NodeG(value);
        nodes.add(nodeG);
        return nodeG;
    }

    public void addEdge(NodeG src, NodeG dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void printGraph() {
        int threshold = 10;  
        for (NodeG nodeG : nodes) {
            boolean hasEdges = false;  
            for (NodeG neighbor : nodeG.getNeighbors()) {
                if (nodeG.getValue() + neighbor.getValue() > threshold) {  
                    if (!hasEdges) {
                        System.out.print("Vertice: " + nodeG.getValue());
                        hasEdges = true;
                    }
                    System.out.print(" -> " + neighbor.getValue());
                }
            }
            if (hasEdges) {
                System.out.println();
            }
        }
    }
    
}
