package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else {
            return node; // No se permiten valores duplicados
        }

        // Actualizar la altura del nodo
        node.setHeight(1 + Math.max(
            height(node.getLeft()),
            height(node.getRight())
        ));

        // Calcular balance o factor de equilibrio
        int balance = getBalance(node);

        // Caso I.I (Izquierda-Izquierda)
        if (balance > 1 && value < node.getLeft().getValue()) {
            return rightRotation(node);
        }

        // Caso D.D (Derecha-Derecha)
        if (balance < -1 && value > node.getRight().getValue()) {
            return leftRotation(node);
        }

        // Caso I.D (Izquierda-Derecha)
        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotation(node.getLeft()));
            return rightRotation(node);
        }

        // Caso D.I (Derecha-Izquierda)
        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotation(node.getRight()));
            return leftRotation(node);
        }

        return node; // Nodo sin cambios
    }

    private Node rightRotation(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: " + y.getValue());

        // Realizar rotación
        x.setRight(y);
        y.setLeft(temp);

        // Actualizar alturas
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        return x;
    }

    private Node leftRotation(Node x) {
        Node y = x.getRight(); // Cambiado a getRight()
        Node temp = y.getLeft();

        System.out.println("Rotamos izquierda el nodo: " + x.getValue());

        // Realizar rotación
        y.setLeft(x);
        x.setRight(temp);

        // Actualizar alturas
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        return y;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    public void printTree() {
        printTreeNode2(root, "", true);
    }

    private void printTreeNode2(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                printTreeNode2(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                printTreeNode2(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }
}
