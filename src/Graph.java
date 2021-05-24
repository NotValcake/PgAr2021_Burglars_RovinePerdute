public class Graph {

    private final int[][] adjmat;

    public Graph(int v) {
        this.adjmat = new int[v][v];
    }

    /**
     * Gets the number of nodes in the graph
     *
     * @return number of nodes
     */
    public int getVertexNum() {
        return adjmat.length;
    }

    /**
     * Gets the requested node with all of his edges
     *
     * @param v index of the wanted node
     * @return the wanted node with all of his edges
     */
    public int[] getVertex(int v) {
        return adjmat[v];
    }

    /**
     * Adds an Edge between the two specified nodes
     *
     * @param from starting node index
     * @param to   destination node index
     */
    public void addEdge(int from, int to) {
        adjmat[from][to] = 1;
    }

    /**
     * gets the value of the edge between the two specified nodes
     *
     * @param from starting node index
     * @param to   destination node index
     * @return 1 if the Edge exists
     * @throws IllegalArgumentException if the same node is given as starting and dastination
     */
    public int getEdge(int from, int to) {
        if (from == to) {
            throw (new IllegalArgumentException());
        }
        return adjmat[from][to];
    }
}

