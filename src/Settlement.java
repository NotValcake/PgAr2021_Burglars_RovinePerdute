import java.util.ArrayList;
import java.util.Objects;

public class Settlement implements Comparable{

    private static int X = 0;
    private static int Y = 1;
    private static int HEIGHT = 2;

    private String name;
    private int id;
    private int[] coords = new int[3];
    private double fuel_to_the_quickest = Double.POSITIVE_INFINITY; //utility attribute meant to be used for pathfinding
    private Integer nearest_id = null;

    private ArrayList<Integer> connectedTo = new ArrayList<>();

    public Settlement(String name, int id, int[] coords) {
        this.name = name;
        this.id = id;
        this.coords = coords;
    }




    public Settlement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return coords[X];
    }

    public void setX(int x) {
        this.coords[X] = x;
    }

    public int getY() {
        return coords[Y];
    }

    public void setY(int y) {
        this.coords[Y] = y;
    }

    public int getHeight() {
        return coords[HEIGHT];
    }

    public void setHeight(int h) {
        this.coords[HEIGHT] = h;
    }

    public void addConnection(Integer to){
        this.connectedTo.add(to);
    }

    public void addConnection(ArrayList links){
        this.connectedTo.addAll(links);
    }


    public boolean isConnected(Settlement to) {
        if (this.equals(to)) {
            throw (new IllegalArgumentException());
        }
        return connectedTo.contains(to);
    }

    public ArrayList<Integer> getConnected(){
        return this.connectedTo;
    }

    public boolean getConnectedById(int id){
        return connectedTo.contains(id);
    }

    public void setFuelToNearest(double fuel){
        this.fuel_to_the_quickest = fuel;
    }

    public double getFuelToTheNearest(){
        return this.fuel_to_the_quickest;
    }

    public Integer getNearestId() {
        return nearest_id;
    }

    public void setNearestId(int nearest_id) {
        this.nearest_id = nearest_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Settlement)) return false;
        Settlement that = (Settlement) o;
        return getId() == that.getId();
    }

    public boolean equals(String name) {
        return this.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }


    public int compareTo(Settlement that) {
        return Double.compare(this.getFuelToTheNearest(), that.getFuelToTheNearest());
    }

    @Override
    public int compareTo(Object that) {
        if(that instanceof Settlement){
            Settlement t = (Settlement) that;
            return Double.compare(this.getFuelToTheNearest(), t.getFuelToTheNearest());
        }
        throw (new IllegalArgumentException());
    }
}
