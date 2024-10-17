public class AppBFS {

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        BFS bfs = new BFS(g, "0");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (bfs.hasPathTo(v)) {
                for (String w : bfs.pathTo(v))
                    System.out.print(w + " (" + bfs.distTo(w) + ") ");
                System.out.println();
            } else
                System.out.println("NÃO TEM CAMINHO");
        }
    }

}
