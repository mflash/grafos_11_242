import java.util.LinkedList;

public class FloydWarshall {

    private static final String NEWLINE = System.getProperty("line.separator");
    private double[][] dist;
    private int[][] next;
    private boolean temCicloNegativo;
    private AdjMatrixEdgeWeightedDigraph g;

    public FloydWarshall(EdgeWeightedDigraph g2) {
        this.g = new AdjMatrixEdgeWeightedDigraph(g2);

        // Inicializar as matrizes
        // Executar o algoritmo!
        temCicloNegativo = false;

        int v = g2.getTotalVerts();
        dist = new double[v][v];
        next = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = Double.POSITIVE_INFINITY;
                if (i == j) {
                    dist[i][j] = 0;
                    next[i][j] = i;
                } else
                    next[i][j] = -1;
            }
        }

        for (Edge e : g2.getEdges()) {
            String v1 = e.getV();
            String w1 = e.getW();
            int indV = g.mapToArray(v1);
            int indW = g.mapToArray(w1);
            dist[indV][indW] = e.getWeight();
            next[indV][indW] = indV;
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[k][j];
                    }
                }
                if (dist[i][i] < 0) {
                    temCicloNegativo = true;
                    return;
                }
            }
        }
    }

    public boolean hasPathTo(String u, String v) {
        int u1 = g.mapToArray(u);
        int v1 = g.mapToArray(v);
        return next[u1][v1] != -1;
    }

    public double distTo(String u, String v) {
        int u1 = g.mapToArray(u);
        int v1 = g.mapToArray(v);
        return dist[u1][v1];
    }

    public Iterable<String> pathTo(String u, String v) {
        LinkedList<String> path = new LinkedList<>();
        int u1 = g.mapToArray(u);
        int v1 = g.mapToArray(v);
        if (next[u1][v1] == -1)
            return path;
        path.add(v);
        while (u1 != v1) {
            v1 = next[u1][v1];
            path.add(0, g.mapToString(v1));
        }
        return path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distâncias:" + NEWLINE);
        sb.append("  ");
        for (int i = 0; i < dist.length; i++) {
            String v = g.mapToString(i);
            sb.append(String.format("%-5s ", v));
        }
        sb.append(NEWLINE);
        for (int i = 0; i < dist.length; i++) {
            String v = g.mapToString(i);
            sb.append(v + " ");
            for (int j = 0; j < dist[i].length; j++) {
                if (next[i][j] != -1)
                    sb.append(String.format("%5.2f ", dist[i][j]));
                else
                    sb.append("----- ");
            }
            sb.append(NEWLINE);
        }
        // Caminhos
        sb.append(NEWLINE + "Caminhos:" + NEWLINE);
        sb.append("  ");
        for (int i = 0; i < next.length; i++) {
            String v = g.mapToString(i);
            sb.append(String.format("%-5s ", v));
        }
        sb.append(NEWLINE);
        for (int i = 0; i < next.length; i++) {
            String v = g.mapToString(i);
            sb.append(v + " ");
            for (int j = 0; j < next[i].length; j++) {
                if (next[i][j] != -1) {
                    String w = g.mapToString(next[i][j]);
                    sb.append(String.format("%-5s ", w));
                } else
                    sb.append("----- ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
