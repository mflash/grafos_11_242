public class AppCaminhoCritico {

    public static void main(String[] args) {
        In arq = new In("exemplos/jobs.txt");

        EdgeWeightedDigraph dg = new EdgeWeightedDigraph();

        while (arq.hasNextLine()) {
            String line = arq.readLine();
            String[] dados = line.split(" ");
            String jobNum = dados[0];
            int dur = Integer.parseInt(dados[1]);
            String jobFim = jobNum + "f";
            dg.addEdge(jobNum, jobFim, dur);
            for (int i = 2; i < dados.length; i++) {
                String dep = dados[i];
                dg.addEdge(jobFim, dep, 0);
            }
            dg.addEdge("START", jobNum, 0);
            dg.addEdge(jobFim, "END", 0);
        }
        System.out.println(dg.toDot());

        for (Edge e : dg.getEdges())
            e.setWeight(-e.getWeight());

        Dijkstra dij = new Dijkstra(dg, "START");

        for (Edge e : dg.getEdges())
            e.setWeight(-e.getWeight());

        // Exibe caminho crítico na tela
        // (será o maior caminho de START a END)
        for (String v : dij.pathTo("END")) {
            System.out.println("==> " + v);
        }
        System.out.println("Duração mínima: " + (-dij.getDist("END")));
    }
}
