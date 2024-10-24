public class AppCicloDirigido {

    public static void main(String[] args) {
        Digraph g = new Digraph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        g.addEdge("A", "D");
        g.addEdge("C", "E");
        g.addEdge("F", "G");
        g.addEdge("G", "H");
        g.addEdge("H", "F");
        System.out.println(g.toDot());

        CicloDirigido detecta = new CicloDirigido(g);
        if (detecta.temCiclo())
            System.out.println("TEM CICLO!");
        else
            System.out.println("Não tem ciclo...");
    }
}
