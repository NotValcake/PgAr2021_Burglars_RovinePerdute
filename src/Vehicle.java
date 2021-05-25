import java.util.ArrayList;
import java.util.TreeMap;

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
    private MyMap getMinimumPaths() {//TODO finire implementazione Dij

        //boolean[] visited = new boolean[getMap().getNodesNum()]; //array di boolean che contiene i nodi visitati
        ArrayList<TreeMap<Integer, Double>> nodes = new ArrayList<>();//for each node, the key will hold the previous and the second box will hold their distance

        for (int i = 0; i < map.getNodes().size(); i++){
            nodes.add(new TreeMap<>());
        }

        for (int i = 0; i < map.getNodes().size(); i++) {

            for (int j = 0; j < map.getNode(i).getConnected().size(); j++) {
                double min_fuel = getFuel(map.getNode(i).getConnected().get(j), map.getNode(j));
                if(min_fuel <= nodes.get(i).get(nodes.get(i).firstKey())){
                    nodes.get(i).clear();
                    nodes.get(i).put(map.getNode(i).getId(), min_fuel);
                }
            }

        }
        return null;
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
