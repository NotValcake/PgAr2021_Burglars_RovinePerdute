public abstract class Vehicle {

    private Graph map;

    public Vehicle(Graph map) {
        this.map = map;
    }

    /**
     * gets the minimum spanning three out of the map
     *
     * @return a Graph containing the minimum spanning three
     */
    public abstract Graph getMinimumPaths();

    /**
     * Finds the quickest path to the "to" destination
     *
     * @param to the destination we want to get the quickest path for
     * @return an array of int containing the list of nodes
     */
    public abstract int[] findQuickestPath(int to);

}
