public class GroundVehicle extends Vehicle{

    private static final double EPSILON = 1e-14;

    public GroundVehicle(MyMap map) {
        super(map);
    }

    //TODO da implementare
    @Override
    public MyMap getMinimumPaths() {
        double mindistance = 0; //da porre a infinito
        Settlement prev = null;
        for (int i = 0; i < getMap().getNodesNum(); i++) {
            for (Settlement s: getMap().getNode(i).getConnected()) {
                if(getDistance(getMap().getNode(i), s) - mindistance < EPSILON){
                    mindistance = getDistance(getMap().getNode(i), s);
                }
            }
        }
        return null;
    }

    @Override
    public int[] findQuickestPath(int to) {
        return new int[0];
    }

    private double getDistance(Settlement from, Settlement to){
        return Math.sqrt(Math.pow(from.getX()-to.getX(), 2) +  Math.pow(from.getY()-to.getY(), 2));
    }
}
