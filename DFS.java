import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private String start;

    public DFS(Graph g, String start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        edgeTo.put(start, null);
        dfs(g, start);
        // System.out.println("edgeTo:");
        // for (String v : edgeTo.keySet()) {
        // System.out.println(v + " -> " + edgeTo.get(v));
        // }
    }

    public boolean hasPathTo(String v) {
        if (marked.contains(v))
            return true;
        return false;
    }

    public Iterable<String> pathTo(String v) {
        if (!hasPathTo(v))
            return null;
        List<String> path = new LinkedList<>();
        while (v != null) {
            path.add(0, v); // insere no início da lista
            v = edgeTo.get(v);
        }
        return path;
    }

    private void dfs(Graph g, String v) {
        // System.out.println("Começou: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            if (!marked.contains(w)) // não passei por w?
            {
                edgeTo.put(w, v);
                dfs(g, w);
            }
        }
        // System.out.println("Terminou: " + v);
    }
}