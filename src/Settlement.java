import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Settlement {

    private static int X = 0;
    private static int Y = 1;
    private static int HEIGHT = 2;

    private String name;
    private int id;
    private int[] coords = new int[3];

    private ArrayList<Settlement> connectedTo = new ArrayList<>();

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

    public void addConnection(Settlement to){
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

    public ArrayList<Settlement> getConnected(){
        return this.connectedTo;
    }

    public Settlement getConnectedById(int id){
        for (Settlement s :
                connectedTo) {
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public Settlement getConnectedByName(String name ){
        for (Settlement s :
                connectedTo) {
            if (s.equals(name)){
                return s;
            }
        }
        return null;
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
}
