import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstra {

    private Map<String, Edge> edgeTo;
    private Map<String, Double> distTo;
    private IndexMinHeap<String, Double> pq;

    public Dijkstra(EdgeWeightedDigraph g, String s) {
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new IndexMinHeap<>();

        for (String v : g.getVerts())
            distTo.put(v, Double.POSITIVE_INFINITY);
        distTo.put(s, 0.0);

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            String v = pq.delMin();
            for (Edge e : g.getAdj(v)) {
                relax(e);
            }
        }
    }

    public boolean hasPathTo(String v) {
        if (edgeTo.containsKey(v))
            return true;
        return false;
    }

    public Iterable<String> pathTo(String v) {
        if (!hasPathTo(v))
            return null;
        List<String> path = new LinkedList<>();
        while (v != null) {
            path.add(0, v); // insere no início da lista
            Edge e = edgeTo.get(v);
            if (e == null)
                v = null;
            else
                v = e.getV();
        }
        return path;
    }

    public double distTo(String v) {
        return distTo.get(v);
    }

    private void relax(Edge e) {
        String v = e.getV();
        String w = e.getW();
        double novaDist = distTo.get(v) + e.getWeight();
        if (distTo.get(w) > novaDist) {
            distTo.put(w, novaDist);
            edgeTo.put(w, e);
            if (pq.contains(w))
                pq.decreaseValue(w, novaDist);
            else
                pq.insert(w, novaDist);
        }
    }
}
