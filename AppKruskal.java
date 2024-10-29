public class AppKruskal {

    public static void main(String[] args) {

        EdgeWeightedGraph g = new EdgeWeightedGraph("exemplos/tinyEWG.txt");
        Kruskal k = new Kruskal(g);

        System.out.println("Custo total: " + k.getTotalCost());
        for (Edge e : k.getTree())
            System.out.println(e);

        System.out.println(g.toDot());
    }
}
