public class FloydWarshall {

    private double[][] dist;
    private int[][] next;
    private AdjMatrixEdgeWeightedDigraph g;
    private boolean temCicloNegativo;

    public FloydWarshall(EdgeWeightedDigraph g2) {

        g = new AdjMatrixEdgeWeightedDigraph(g2);
        int totalV = g.getTotalVertices();
        temCicloNegativo = false;
        System.out.println(g);

        dist = new double[totalV][totalV];
        next = new int[totalV][totalV];

        for (Edge e : g2.getEdges()) {
            int u = g.mapToArray(e.getV());
            int v = g.mapToArray(e.getW());
            dist[u][v] = e.getWeight();
            next[u][v] = v;
            if (u == v) {
                dist[u][v] = 0;
                next[u][v] = v;
            }
        }

        // Rodar Floyd-Warshall
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");
        FloydWarshall fw = new FloydWarshall(g);
    }
}
