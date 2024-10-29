import java.util.LinkedList;
import java.util.List;

public class Kruskal {

    private List<Edge> tree;
    private double totalCost;

    public Kruskal(EdgeWeightedGraph g) {
        totalCost = 0;
        tree = new LinkedList<>();
        UnionFind uf = new UnionFind(g);

        MinHeap<Edge> pq = new MinHeap<>();
        for (Edge e : g.getEdges())
            pq.put(e);

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            // System.out.println(e);
            String setV = uf.find(e.getV());
            String setW = uf.find(e.getW());
            if (!setV.equals(setW)) {
                e.setColor("color=red penwidth=3");
                tree.add(e);
                uf.union(setV, setW);
                totalCost += e.getWeight(); // adiciona o peso da aresta ao custo total
            }
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Iterable<Edge> getTree() {
        return tree;
    }

    // public String toDot() {
    //
    // }
}
