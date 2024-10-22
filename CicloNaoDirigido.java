import java.util.HashSet;
import java.util.Set;

public class CicloNaoDirigido {

    private Set<String> marked;
    private Set<String> arestas;
    private boolean temCiclo;

    public CicloNaoDirigido(Graph g) {
        marked = new HashSet<>();
        arestas = new HashSet<>();
        temCiclo = false;
        for (String v : g.getVerts()) {
            if (!marked.contains(v)) {
                temCiclo = dfs(g, v);
                if (temCiclo)
                    return;
            }
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private boolean dfs(Graph g, String v) {
        // Implementar containsCycle
        return false;
    }
}
