import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OrdTopologica {
    private Set<String> marked;
    private List<String> ordemTopo;

    public OrdTopologica(Digraph g) {
        marked = new HashSet<>();
        ordemTopo = new LinkedList<>();
        for (String v : g.getVerts()) {
            if (!marked.contains(v))
                dfs(g, v);
        }
    }

    public Iterable<String> ordemTopologica() {
        return ordemTopo;
    }

    private void dfs(Graph g, String v) {
        // System.out.println("Começou: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            if (!marked.contains(w)) // não passei por w?
                dfs(g, w);
        }
        ordemTopo.add(0, v); // pós-ordem reversa (ord. topológica)
        // System.out.println("Terminou: " + v);
    }
}