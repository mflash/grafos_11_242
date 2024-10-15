public class AppDFS {

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        DFS dfs = new DFS(g, "7");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (dfs.hasPathTo(v)) {
                for (String w : dfs.pathTo(v))
                    System.out.print(w + " ");
                System.out.println();
            } else
                System.out.println("NÃO TEM CAMINHO");
        }
    }

}
