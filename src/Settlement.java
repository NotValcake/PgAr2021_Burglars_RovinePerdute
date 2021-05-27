import java.util.ArrayList;
import java.util.Objects;

public class Settlement implements Comparable<Settlement> {

    private static final int X = 0;
    private static final int Y = 1;
    private static final int HEIGHT = 2;

    private String name;
    private int id;
    private int[] coords = new int[3];
    private double fuelFromStart = Double.POSITIVE_INFINITY; //utility attribute meant to be used for pathfinding
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

    public void addConnection(Integer to) {

        this.connectedTo.add(to);
    }

    public void addConnection(ArrayList links) {

        this.connectedTo.addAll(links);
    }


    public boolean isConnected(Settlement to) {
        if (this.equals(to)) {
            throw (new IllegalArgumentException());
        }
        return connectedTo.contains(to);
    }

    public ArrayList<Integer> getConnected() {

        return this.connectedTo;
    }

    public boolean getConnectedById(int id) {

        return connectedTo.contains(id);
    }

    public void setFuelToNearest(double fuel) {

        this.fuelFromStart = fuel;
    }

    public double getFuelFromStart() {

        return this.fuelFromStart;
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

    @Override
    public int compareTo(Settlement that) {
        return Double.compare(this.getFuelFromStart(), that.getFuelFromStart());
    }
}
