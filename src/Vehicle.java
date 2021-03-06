import java.util.*;

public abstract class Vehicle {

    private final MyMap map;

    public Vehicle(MyMap map) {
        this.map = map;
    }

    /**
     * gets the minimum spanning three out of the map
     *
     * @return a MyMap instance containing the minimum spanning three
     */
    //TODO QUI COMINCIA LA MAGIA OSCURA, avadakedavra!
    //per me si va nell'etterno grafo,
    //per me si va tra il perduto percorso.
    //[...]
    //Lasciate ogne speranza, voi ch'intrate.
    //L'Inferno by NotValcake
    //All rights reserved
    public MyMap getMinimumPaths() {

        boolean[] visited = new boolean[getMap().getNodesNum()];//tracking visited nodes
        TreeSet<Settlement> mst = new TreeSet<>(); //tracking the next nodes to be visited, initially empty


        //first node setup
        mst.add(getMap().getNode(0));

        getMap().getNode(0).setClosestId(0);
        getMap().getNode(0).setFuelFromStart(0);

        mst.add(getMap().getNode(0));

        //keep iterating until we find our destination node
        while (mst.size() > 0 && !visited[getMap().getNodesNum() - 1]) {

            Settlement current_node = mst.pollFirst(); //check the closest node to the previous one, based on the fuel_from_starting param
            int current_node_id = current_node.getId();
            double current_node_fuel = current_node.getFuelFromStart();

            if (visited[current_node_id]) continue; //if already visited, skip to the next

            visited[current_node_id] = true; //mark current node as visited

            for (Integer s : getMap().getNode(current_node_id).getConnected()) { //check all the nodes connected to the current one
                double temp_fuel = current_node_fuel + getFuel(getMap().getNode(s), getMap().getNode(current_node_id));
                if (temp_fuel < getMap().getNode(s).getFuelFromStart()) { //if the new path to the child node is shorter, update the path
                    getMap().getNode(s).setFuelFromStart(temp_fuel);
                    getMap().getNode(s).setClosestId(current_node_id);
                    if (!visited[s]) { //if we already visited the next node we can skip it
                        mst.add(getMap().getNode(s)); //if not we put it into the treeSet for the next iteration
                    }
                }
            }
        }
        return getMap();
    }

    /**
     * Finds the quickest path to the "to" destination
     *
     * @param to the destination we want to get the quickest path for
     * @return an array of int containing the list of nodes
     */
    public ArrayList<Settlement> findQuickestPath(int to) {
        getMinimumPaths();
        ArrayList<Settlement> route = new ArrayList<>();
        Settlement current_node = getMap().getNode(to);
        while (current_node.getId() != 0) {
            route.add(current_node);
            current_node = getMap().getNode(current_node.getClosestId());
        }
        route.add(current_node);
        Collections.reverse(route);
        return route;
    }

    /**
     * Calculates the fuel consumption to move from a node to another based on the kind of vehicle
     *
     * @param from the starting node
     * @param to   the destination node
     * @return the fuel consumption
     */
    public abstract double getFuel(Settlement from, Settlement to);

    public MyMap getMap() {
        return map;
    }

}
