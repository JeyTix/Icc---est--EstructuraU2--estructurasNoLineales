package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.Materia.Models.NodeG;

public class Graph {
    private List<NodeG> nodes = new ArrayList<>();

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeG addNode(int value) {
        NodeG nodeG = new NodeG(value);
        nodes.add(nodeG);
        return nodeG;
    }

    public void addEdge(NodeG src, NodeG dest) {
        src.addNeighbor(dest); 
    }
    public void addDirectedEdge(NodeG src, NodeG dest) {
        src.addNeighbor(dest); // Directed graph behavior
    }

    public void addUndirectedEdge(NodeG src, NodeG dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void addEdgeUndirected(NodeG src, NodeG dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void printGraph() {
        for (NodeG nG : nodes) {
            System.out.print("Vertice " + nG.getValue() + ": ");
            for (NodeG neighbor : nG.getNeighbors()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }

    public void getDFS(NodeG start) {
        Set<NodeG> visitados = new HashSet<>();
        System.out.print("DFS desde el nodo " + start.getValue() + ": ");
        dfsUtil(start, visitados);
        System.out.println();
    }
    
    private void dfsUtil(NodeG node, Set<NodeG> visitados) {
        if (visitados.contains(node)) return;
        System.out.print(node.getValue() + " ");
        visitados.add(node);
        for (NodeG neighbor : node.getNeighbors()) {
            if (!visitados.contains(neighbor)) {
                dfsUtil(neighbor, visitados);
            }
        }
    }
    
    public void getBFS(NodeG start) {
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();
        System.out.print("BFS desde el nodo " + start.getValue() + ": ");
        cola.add(start);
        visitados.add(start);
        while (!cola.isEmpty()) {
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " ");
            for (NodeG neighbor : actual.getNeighbors()) {
                if (!visitados.contains(neighbor)) {
                    cola.add(neighbor);
                    visitados.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void findPath(NodeG start, int targetValue) {
        Set<NodeG> visited = new HashSet<>();
        System.out.println("Buscando un camino desde el nodo " + start.getValue() + " hasta el nodo " + targetValue);
        if (!findPathDFS(start, targetValue, visited)) {
            System.out.println("No se encontró un camino hacia el nodo " + targetValue);
        }
    }

    private boolean findPathDFS(NodeG current, int targetValue, Set<NodeG> visited) {
        if (current.getValue() == targetValue) {
            System.out.println("Camino encontrado hasta el nodo " + targetValue);
            return true;
        }
        visited.add(current);
        for (NodeG neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor) && findPathDFS(neighbor, targetValue, visited)) {
                System.out.println("Desde el nodo " + current.getValue() + " -> " + neighbor.getValue());
                return true;
            }
        }
        return false;
    }

    public void getDFSPath(NodeG start, int targetValue) {
        Set<NodeG> visitados = new HashSet<>();
        System.out.print("DFS desde el nodo " + start.getValue() + " hasta el nodo " + targetValue + ": ");
        if (!dfsPathUtil(start, targetValue, visitados)) {
            System.out.println("No se encontró un camino hacia el nodo " + targetValue);
        }
        System.out.println();
    }
    
    private boolean dfsPathUtil(NodeG node, int targetValue, Set<NodeG> visitados) {
        if (node.getValue() == targetValue) {
            System.out.print(node.getValue() + " ");
            return true;
        }
        visitados.add(node);
        System.out.print(node.getValue() + " ");
        for (NodeG neighbor : node.getNeighbors()) {
            if (!visitados.contains(neighbor)) {
                if (dfsPathUtil(neighbor, targetValue, visitados)) {
                    return true;
                }
            }
        }
        return false;
    }
    
}