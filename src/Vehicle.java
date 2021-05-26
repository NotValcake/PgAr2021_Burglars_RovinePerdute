import java.util.*;

public abstract class Vehicle {

    private MyMap map;

    public Vehicle(MyMap map) {
        this.map = map;
    }

    /**
     * gets the minimum spanning three out of the map
     *
     * @return a Graph containing the minimum spanning three
     */
    public MyMap getMinimumPaths() {//TODO finire implementazione Dij

        MyMap minimum_paths = this.getMap();

        PriorityQueue<Settlement> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[minimum_paths.getNodesNum()];

        visited[0] = true;
        minimum_paths.getNode(0).setNearestId(0);
        minimum_paths.getNode(0).setFuelToNearest(0);

        queue.add(map.getNode(0));

        while(!queue.isEmpty()){
            Settlement current_node = queue.poll();
            int current_node_id = current_node.getNearestId();
            double current_node_fuel = current_node.getFuelToTheNearest();
            visited[current_node_id] = true;
            for (int s: minimum_paths.getNode(current_node_id).getConnected()) {
                double temp_fuel = current_node_fuel + getFuel(minimum_paths.getNode(s), minimum_paths.getNode(current_node_id));
                if(temp_fuel <= minimum_paths.getNode(current_node_id).getFuelToTheNearest()){
                    minimum_paths.getNode(current_node_id).setFuelToNearest(temp_fuel);
                    minimum_paths.getNode(current_node_id).setNearestId(s);
                    queue.add(minimum_paths.getNode(s));
                }
            }
        }

        return minimum_paths;
    }

    /**
     * Finds the quickest path to the "to" destination
     *
     * @param to the destination we want to get the quickest path for
     * @return an array of int containing the list of nodes
     */
    public int[] findQuickestPath(int to){
        return null;
    }

    /**
     * Calculates the fuel consumption to move from a node to another based on the kind of vehicle
     * @param from the starting node
     * @param to the destination node
     * @return the fuel consumption
     */
    public abstract double getFuel(Settlement from, Settlement to);

    public MyMap getMap(){
        return map;
    }

}
