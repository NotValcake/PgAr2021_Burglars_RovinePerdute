public class Graph {

    private final int[][] adjmat;

    public Graph(int v) {
        this.adjmat = new int[v][v];
    }

    public int getVertexNum() {
        return adjmat.length;
    }

    public int[] getVertex(int v) {
        return adjmat[v];
    }

    public void addEdge(int from, int to) {
        adjmat[from][to] = 1;
    }

    public int getEdge(int from, int to) {
        return adjmat[from][to];
    }
}

