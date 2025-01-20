import main.Ejercicio_01_insert.InsertBSTTEST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_ListLeves.ListLeves;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.Graph;
import main.Materia.Models.Node;
import main.Materia.Models.NodeG;

import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello Profe... ");

        // System.out.println("\t---------- EJERCICIO 1 ----------");
        // runEjercicio1();
        // System.out.println("\n\t---------- EJERCICIO 2 ----------");
        // runEjercicio2();
        // System.out.println("\n\t---------- EJERCICIO 3 ----------");
        // runEjercicio3();
        // System.out.println("\n\t---------- EJERCICIO 4 ----------");
        // runEjercicio4();






        // ArbolBinario arbolBinario = new ArbolBinario();
        // int[]valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        // //ingresar cada valor al arbol
        // for (int i : valores) {
        //     arbolBinario.insert(i);
        // }

        // arbolBinario.printTree(); 

        // Node root = arbolBinario.getRoot();

        // ArbolBinarioRecorrido arbolBinarioRecorrido = new ArbolBinarioRecorrido();
        // System.out.println("PreOrder Iterativo");
        // arbolBinarioRecorrido.preOrderIterativo(root);

        // System.out.println("\nPreOrderRecursivo");
        // arbolBinarioRecorrido.preOrderRecursivo(root);

        // System.out.println("\nPosOrder");
        // arbolBinarioRecorrido.posOrderRecursivo(root);
        
        // System.out.println("\nInOrder");
        // arbolBinarioRecorrido.inOrderRecursivo(root);

        // runEjercicio3();

        // runArbolAVL();

        // runGraph();

        runGraphEjercicio();
    }

    public static void runEjercicio1() {
        ArbolBinario arbolBinario = new ArbolBinario();
        InsertBSTTEST insertHelper = new InsertBSTTEST();  
    
        int[] valores = {5, 3, 7, 2, 4, 6, 8};  
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        Node root = null; 
    
        for (int value : valores) {
            root = insertHelper.insert(root, value);
        }
    
        arbolBinario.setRoot(root);
    
        System.out.println("Árbol Binario después de las inserciones:");
        arbolBinario.printTree(); 
    }
    
    public static void runEjercicio2() {
        ArbolBinario arbolBinario = new ArbolBinario();
        InsertBSTTEST insertHelper = new InsertBSTTEST();
        InvertBinaryTree invertHelper = new InvertBinaryTree();
        
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        Node root = null;
    
        for (int value : valores) {
            root = insertHelper.insert(root, value);
        }
    
        arbolBinario.setRoot(root);
        System.out.println("Árbol Binario Normal:");
        arbolBinario.printTree();
    
        Node invertedRoot = invertHelper.invertTree(root);
        arbolBinario.setRoot(invertedRoot);  
        
        System.out.println("Árbol Binario Invertido:");
        arbolBinario.printTree();
    }
    
    public static void runEjercicio3(){

        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        for (int i: valores){
            arbolBinario.insert(i);
        }
        arbolBinario.printTree();
        Node root = arbolBinario.getRoot();
        ListLeves listLeves = new ListLeves();
        List<List<Node>> levels = listLeves.listLeves(root);

        for (List<Node> level : levels) {
            for (Node node : level) {
                System.out.print(node.getValue() + "-> ");
            }
            System.out.println();
        }
    }

    public static void runEjercicio4() {
        ArbolBinario arbolBinario = new ArbolBinario();
        Depth depthHelper = new Depth();

        int[] valores = {3, 9, 20, 15, 7}; 
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        for (int value : valores) {
            arbolBinario.insert(value);
        }

        System.out.println("Árbol Binario:");
        arbolBinario.printTree();

        int maxDepth = depthHelper.maxDepth(arbolBinario.getRoot());
        System.out.println("La profundidad máxima del árbol binario es: " + maxDepth);
    }

    public static void runGraph() {

        //Grafo Dirigido
        Graph grafo = new Graph();
         
        NodeG node0= grafo.addNode(0);
        NodeG node1= grafo.addNode(1);
        NodeG node2= grafo.addNode(2);
        NodeG node3= grafo.addNode(3);
        NodeG node4= grafo.addNode(4);
        NodeG node5= grafo.addNode(5);

        grafo.addEdge(node0,node3);
        grafo.addEdge(node3,node2);
        grafo.addEdge(node2,node1);
        grafo.addEdge(node0,node5);
        grafo.addEdge(node3,node4);
        grafo.addEdge(node1,node0);

        grafo.printGraph();
        
        grafo.getDFS(node0);
        grafo.getBFS(node0);

        // Grafo No Dirigido
        Graph undirectedGraph = new Graph();
        
        NodeG uNode0 = undirectedGraph.addNode(0);
        NodeG uNode1 = undirectedGraph.addNode(1);
        NodeG uNode2 = undirectedGraph.addNode(2);
        NodeG uNode3 = undirectedGraph.addNode(3);
        NodeG uNode4 = undirectedGraph.addNode(4);
        NodeG uNode5 = undirectedGraph.addNode(5);

        undirectedGraph.addEdgeUndirected(uNode0, uNode3);
        undirectedGraph.addEdgeUndirected(uNode0, uNode5);
        undirectedGraph.addEdgeUndirected(uNode3, uNode2);
        undirectedGraph.addEdgeUndirected(uNode3, uNode4);
        undirectedGraph.addEdgeUndirected(uNode2, uNode1);
        undirectedGraph.addEdgeUndirected(uNode4, uNode1);
        undirectedGraph.addEdgeUndirected(uNode1, uNode0);

        System.out.println("\nGrafo no dirigido:");
        undirectedGraph.printGraph();

        undirectedGraph.getDFS(uNode0);
        undirectedGraph.getBFS(uNode0);
    }

    public static void runGraphEjercicio() {
        Graph grafo = new Graph();

        NodeG node0 = grafo.addNode(0);
        NodeG node1 = grafo.addNode(1);
        NodeG node2 = grafo.addNode(2);
        NodeG node3 = grafo.addNode(3);
        NodeG node4 = grafo.addNode(4);
        NodeG node5 = grafo.addNode(5);
        NodeG node7 = grafo.addNode(7);
        NodeG node8 = grafo.addNode(8);
        NodeG node9 = grafo.addNode(9);

        grafo.addDirectedEdge(node0, node1);
        grafo.addDirectedEdge(node0, node5);
        grafo.addDirectedEdge(node1, node2);
        grafo.addDirectedEdge(node1, node4);
        grafo.addDirectedEdge(node1, node8);
        grafo.addDirectedEdge(node2, node3);
        grafo.addDirectedEdge(node3, node0);
        grafo.addDirectedEdge(node3, node4);
        grafo.addDirectedEdge(node3, node7);
        grafo.addDirectedEdge(node4, node7);
        grafo.addDirectedEdge(node7, node9);
        grafo.addDirectedEdge(node9, node3);

        System.out.println("Grafo no dirigido:");
        grafo.printGraph();

        System.out.println("\nNo direccional:");
        grafo.getDFS(node0);
        System.out.println("\nRealizando DFS desde el nodo 0 hasta el nodo 7:");
        grafo.getDFSPath(node0, 7);


        System.out.println();
    }

    // private static void runArbolAVL() {
    //     int[] values = {10, 20, 15, 24, 9, 8, 21};
    //     ArbolAVL arbol = new ArbolAVL();
    
    //     for (int value : values) {
    //         System.out.println("* Nodo a insertar: " + value);
    //         arbol.insert(value);
    
    //         Node root = arbol.getRoot();
    //         Stack<Node> stack = new Stack<>();
    //         stack.push(root);
    
    //         boolean rotationHappened = false;
    
    //         while (!stack.isEmpty()) {
    //             Node current = stack.pop();
    //             int leftHeight = (current.getLeft() != null) ? current.getLeft().getHeight() : 0;
    //             int rightHeight = (current.getRight() != null) ? current.getRight().getHeight() : 0;
    //             int balance = leftHeight - rightHeight;
    
    //             String rotationType = "";
    //             if (balance > 1) {
    //                 rotationType = (current.getLeft() != null && value > current.getLeft().getValue()) ? "Izquierda-Derecha" : "Derecha";
    //                 rotationHappened = true;
    //             } else if (balance < -1) {
    //                 rotationType = (current.getRight() != null && value < current.getRight().getValue()) ? "Derecha-Izquierda" : "Izquierda";
    //                 rotationHappened = true;
    //             }
    
    //             System.out.println("- Nodo actual: " + current.getValue());
    //             System.out.println("  Altura del nodo: " + current.getHeight());
    //             System.out.println("  Equilibrio del nodo: " + balance);
    
    //             if (!rotationType.isEmpty()) {
    //                 System.out.println("  Rotación " + rotationType + " en nodo " + current.getValue() + ", Balance: " + balance);
    //                 System.out.println("  Nueva raíz después de rotación: " + root.getValue());
    //             }
    
    //             if (current.getRight() != null) stack.push(current.getRight());
    //             if (current.getLeft() != null) stack.push(current.getLeft());
    //         }
    
    //         System.out.println("Árbol AVL después de insertar " + value + ":");
    //         arbol.printTree();
    //         System.out.println();
    //     }
    
    //     System.out.println("FIN");
    // }
    
}