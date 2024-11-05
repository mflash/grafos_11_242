public class AppDijsktra {

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");

        System.out.println(g.toDot());

        Dijkstra dij = new Dijkstra(g, "0");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (dij.hasPathTo(v)) {
                System.out.print("(" + dij.distTo(v) + ") ");
                for (String w : dij.pathTo(v))
                    System.out.print(w + " ");
                System.out.println();
            } else
                System.out.println("NÃO TEM CAMINHO");
        }
    }

}
