public class GroundVehicle extends Vehicle{

    private static final double EPSILON = 1e-14;

    public GroundVehicle(MyMap map) {
        super(map);
    }

    @Override
    public double getFuel(Settlement from, Settlement to){
        return Math.sqrt(Math.pow(from.getX()-to.getX(), 2) +  Math.pow(from.getY()-to.getY(), 2));
    }
}
