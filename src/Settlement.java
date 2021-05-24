public class Settlement {

    private static int X = 0;
    private static int Y = 1;
    private static int HEIGHT = 2;

    private String name;
    private int id;
    private int[] coords = new int[3];

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
        return coords[X];
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
}
