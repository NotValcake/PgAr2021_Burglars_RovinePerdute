public class GroundVehicle extends Vehicle{

    private static final double EPSILON = 1e-14;

    public GroundVehicle(MyMap map) {
        super(map);
    }

    //TODO da implementare
    public MyMap getMinimumPaths() {
        double mindistance = 0; //da porre a infinito
        Settlement prev = null;
        for (int i = 0; i < getMap().getNodesNum(); i++) {
            for (Settlement s: getMap().getNode(i).getConnected()) {
                if(getFuel(getMap().getNode(i), s) - mindistance < EPSILON){
                    mindistance = getFuel(getMap().getNode(i), s);
                }
            }
        }
        return null;
    }

    @Override
    public double getFuel(Settlement from, Settlement to){
        return Math.sqrt(Math.pow(from.getX()-to.getX(), 2) +  Math.pow(from.getY()-to.getY(), 2));
    }
}
