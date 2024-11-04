public class AppOrdTopologica {

    public static void main(String[] args) {
        // Este exemplo NÃO é um DAG (tem ciclo)
        // Digraph g = new Digraph("exemplos/tinyDG.txt");
        Digraph g = new Digraph("exemplos/tinyDAG.txt");

        CicloDirigido detecta = new CicloDirigido(g);
        if (detecta.temCiclo())
            System.out.println("Impossível realizar ordenação topológica (tem ciclo)!");
        else {
            OrdTopologica ot = new OrdTopologica(g);

            System.out.println(g.toDot());

            for (String v : ot.ordemTopologica())
                System.out.println(v);
        }
    }

}
