public class AppComparacaoCaminhosMinimos {

    public static void main(String[] args) {

        // Em um desses exemplos, Floyd-Warshall é MELHOR que Dijkstra
        // Por que?

        // EdgeWeightedDigraph g = WeightedDigraphGenerator.dag(1000, 1500);
        // EdgeWeightedDigraph g = WeightedDigraphGenerator.complete(1000);
        EdgeWeightedDigraph g = WeightedDigraphGenerator.rootedInDAG(10000, 12000);
        // System.out.println(g.toDot());

        System.out.println("Floyd-Warshall:");
        long start = System.nanoTime();
        // FloydWarshall fw = new FloydWarshall(g);
        long end = System.nanoTime();
        double delta = (end - start) / 1e9;
        System.out.println("Tempo: " + delta);

        System.out.println("Dijsktra:");
        start = System.nanoTime();
        for (String v : g.getVerts()) {
            Dijkstra dij = new Dijkstra(g, v);
        }
        end = System.nanoTime();
        delta = (end - start) / 1e9;
        System.out.println("Tempo: " + delta);

    }
}
