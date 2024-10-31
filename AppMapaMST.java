import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppMapaMST {

    private class Ponto implements Comparable<Ponto> {
        public int pos;
        public double x, y;
        public double dist;

        public Ponto(int pos, double x, double y) {
            this.pos = pos;
            this.x = x;
            this.y = y;
            this.dist = 0;
        }

        @Override
        public int compareTo(AppMapaMST.Ponto o) {
            if (this.dist > o.dist)
                return 1;
            else if (this.dist < o.dist)
                return -1;
            return 0;
        }
    }

    public AppMapaMST(String nomeArq) {
        In arq = new In("exemplos/dados.csv");
        List<Ponto> pontos = new ArrayList<>();
        int totalPontos = 0;
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(";");
            double x, y;
            y = Double.parseDouble(dados[0]);
            x = Double.parseDouble(dados[1]);
            pontos.add(new Ponto(totalPontos, x, y));
            totalPontos++;
        }

        EdgeWeightedGraph g = new EdgeWeightedGraph();

        for (int pos1 = 0; pos1 < pontos.size(); pos1++) {
            double x1 = pontos.get(pos1).x;
            double y1 = pontos.get(pos1).y;
            List<Ponto> pontosAux = new ArrayList<>(pontos);
            for (int pos2 = 0; pos2 < pontos.size(); pos2++) {
                if (pos1 != pos2) {
                    Ponto p = pontosAux.get(pos2);
                    double x2 = p.x;
                    double y2 = p.y;
                    double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                    p.dist = dist;
                }
            }
            Collections.sort(pontosAux);
            // for (Ponto p : pontosAux) {
            // System.out.println(p.pos + " -> " + p.dist);
            // }
            Ponto inicio = pontos.get(pos1);
            for (int a = 1; a <= 5; a++) {
                Ponto fim = pontosAux.get(a);
                g.addEdge("" + inicio.pos, "" + fim.pos, fim.dist);
            }
        }
        Kruskal k = new Kruskal(g);
        for (Edge e : g.getEdges()) {
            int estaNaArvore = 0;
            if (e.getColor() != "")
                estaNaArvore = 1;
            System.out.println(e.getV() + " " + e.getW() + " " + estaNaArvore);
        }
    }

    public static void main(String[] args) {
        AppMapaMST app = new AppMapaMST("exemplos/dados.csv");
    }
}
