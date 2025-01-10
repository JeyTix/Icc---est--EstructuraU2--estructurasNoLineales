import main.Ejercicio_03_ListLeves.ListLevels;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolBinarioRecorrido;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
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

        runEjercicio3();

    }

    public static void runEjercicio3(){
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int i : valores) {
            arbolBinario.insert(i);
        }
        arbolBinario.printTree();
        ListLevels niveles = new ListLevels();

        Node root = arbolBinario.getRoot();

        niveles.listLevel(root);
    }
}