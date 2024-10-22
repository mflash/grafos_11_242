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
        // Para cada vértice ainda não marcado...
        // (isto é, não visitado na chamada anterior)
        for (String v : g.getVerts()) {
            if (!marked.contains(v)) {
                System.out.println("Testando: " + v);
                temCiclo = containsCycle(g, v);
                if (temCiclo)
                    return;
            }
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private boolean containsCycle(Graph g, String v) {
        System.out.println(">> Visitando: " + v);
        marked.add(v);
        for (String u : g.getAdj(v)) {
            if (!marked.contains(u)) {
                String e = u + "-" + v;
                System.out.println("   Adicionando aresta: " + e);
                arestas.add(e);
                boolean res = containsCycle(g, u);
                if (res)
                    return res;
            } else {
                // Verifica se chegou em u por OUTRO caminho
                String e = v + "-" + u;
                System.out.println("   Verificando aresta: " + e);
                if (!arestas.contains(e))
                    return true; // achei um ciclo!
            }
        }
        return false;
    }
}
