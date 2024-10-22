public class AppCicloNaoDirigido {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        // g.addEdge("D", "A");
        g.addEdge("C", "E");
        g.addEdge("F", "G");
        g.addEdge("G", "H");
        g.addEdge("H", "F");
        System.out.println(g.toDot());
        CicloNaoDirigido detecta = new CicloNaoDirigido(g);
        if (detecta.temCiclo())
            System.out.println("TEM CICLO!");
        else
            System.out.println("Não tem ciclo...");
    }
}
