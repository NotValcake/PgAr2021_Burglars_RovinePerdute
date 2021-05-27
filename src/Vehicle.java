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
    //TODO QUI COMINCIA LA MAGIA OSCURA, avadakedavra!
    //per me si va nell'etterno grafo,
    //per me si va tra il perduto percorso.
    //[...]
    //Lasciate ogne speranza, voi ch'intrate.
    //L'Inferno by NotValcake
    //All rights reserved
    public MyMap getMinimumPaths() {

        MyMap minimum_paths = this.getMap();

        TreeSet<Settlement> mst = new TreeSet<>(); //our minimum spanning tree, initially empty

        PriorityQueue<Settlement> queue = new PriorityQueue<>();

        mst.add(getMap().getNode(0));

        getMap().getNode(0).setNearestId(0);
        getMap().getNode(0).setFuelToNearest(0);

        queue.add(getMap().getNode(0));

        while(mst.size() != getMap().getNodesNum()){ //finchè il nostro mst non contiene tutti i nodi proseguo

            Settlement current_node = queue.poll();
            int current_node_id = current_node.getId();
            double current_node_fuel = current_node.getFuelToTheNearest();
            mst.add(current_node);

            for (Integer s: getMap().getNode(current_node_id).getConnected()) {
                double temp_fuel = current_node_fuel + getFuel(getMap().getNode(s), getMap().getNode(current_node_id));
                if(temp_fuel <= getMap().getNode(s).getFuelToTheNearest()){
                    getMap().getNode(s).setFuelToNearest(temp_fuel);
                    getMap().getNode(s).setNearestId(current_node_id);
                    if(mst.contains(getMap().getNode(s))) continue;
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
