import java.util.HashMap;
import java.util.Map;

public class CicloDirigido {

    private enum Cores {
        WHITE, GREY, BLACK
    }

    private Map<String, Cores> marked;
    private boolean temCiclo;

    public CicloDirigido(Digraph g) {
        marked = new HashMap<>();
        for (String v : g.getVerts())
            marked.put(v, Cores.WHITE);
        temCiclo = false;
        // Para cada vértice ainda não marcado...
        // (isto é, não visitado na chamada anterior)
        for (String v : g.getVerts()) {
            if (marked.get(v) == Cores.WHITE) {
                System.out.println("Testando: " + v);
                temCiclo = visit(g, v);
                if (temCiclo)
                    return;
            } else
                System.out.println("Já visitado: " + v);
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private boolean visit(Graph g, String v) {
        System.out.println(">> Visitando: " + v);
        marked.put(v, Cores.GREY);
        for (String u : g.getAdj(v)) {
            if (marked.get(u) == Cores.GREY) {
                return true;
            } else if (marked.get(u) == Cores.WHITE) {
                if (visit(g, u))
                    return true;
            }
        }
        marked.put(v, Cores.BLACK);
        return false;
    }
}
