public class JumpingVehicle extends Vehicle {

    public JumpingVehicle(MyMap map) {
        super(map);
    }

    /**
     * returns the fuel consumption which corresponds to the height difference
     *
     * @param from the starting node
     * @param to   the destination node
     * @return the fuel consumption
     */
    @Override
    public double getFuel(Settlement from, Settlement to) {
        return (Math.abs(from.getHeight() - to.getHeight()));
    }
}
