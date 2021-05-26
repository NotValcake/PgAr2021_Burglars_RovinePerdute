public class VehicleTest {



    public static void main(String[] args) {
        int[] coords= new int[3];
        coords[0] = 4;
        coords[1] = 3;

        Settlement s1 = new Settlement( "A", 0, coords);
        coords[0] = 45;
        coords[1] = 5;
        Settlement s2 = new Settlement( "B", 1, coords);
        coords[0] = 6;
        coords[1] = 3;
        Settlement s3 = new Settlement( "C", 2, coords);
        coords[0] = 8;
        coords[1] = 2;
        Settlement s4 = new Settlement( "D", 3, coords);
        coords[0] = 43;
        coords[1] = 34;
        Settlement s5 = new Settlement( "E", 4, coords);
        coords[0] = 8;
        coords[1] = 4;
        Settlement s6 = new Settlement( "F", 5, coords);
        coords[0] = 8;
        coords[1] = 1;
        Settlement s7 = new Settlement( "G", 6, coords);
        coords[0] = 3;
        coords[1] = 6;
        Settlement s8 = new Settlement( "H", 7, coords);
        coords[0] = 7;
        coords[1] = 4;
        Settlement s9 = new Settlement( "I", 8, coords);

        MyMap map = new MyMap();

        map.addNode(s1);
        map.addNode(s2);
        map.addNode(s3);
        map.addNode(s4);
        map.addNode(s5);
        map.addNode(s6);
        map.addNode(s7);
        map.addNode(s8);

        GroundVehicle v = new GroundVehicle(map);

        MyMap min = v.getMinimumPaths();

        for (Settlement s: min.getNodes()) {
            System.out.printf("%s -> %d\n", s.getName(), s.getNearestId());
        }
    }

}
