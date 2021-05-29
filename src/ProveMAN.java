import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class ProveMAN {

    private static final String teamJump = "Metztli";
    private static final String teamGround = "Tonatiuh";
    private static final String IN = "test_file/PgAr_Map_5.xml";

    private static final String[] INPUT_FILES = {
            "test_file/PgAr_Map_5.xml",
            "test_file/PgAr_Map_12.xml",
            "test_file/PgAr_Map_50.xml",
            "test_file/PgAr_Map_200.xml",
            "test_file/PgAr_Map_2000.xml",
            "test_file/PgAr_Map_10000.xml"};


    public static void main(String[] args) throws XMLStreamException {

        //String input_file = INPUT_FILES[UserInterface.controllaScelta(INPUT_FILES.length)];

        ArrayList<Settlement> settlements1 = XMLReader.readMap(IN);

        MyMap mapJ = new MyMap(settlements1);

        ArrayList<Settlement> settlements2 = new ArrayList<>();

        for (Settlement s : settlements1) {
            settlements2.add(Settlement.clone(s));
        } //shallow copying the array and its objects

        MyMap mapG = new MyMap(settlements2);  //da usare per ciascun veicolo

        JumpingVehicle vJ = new JumpingVehicle(mapJ);
        GroundVehicle vG = new GroundVehicle(mapG);

        Route rottaJ = new Route(teamJump, mapJ);
        rottaJ.setRoute(vJ, mapJ.getDestination());

        Route rottaG = new Route(teamGround, mapG);
        rottaG.setRoute(vG, mapG.getDestination());
        int scelta;

        do {

            System.out.println("from indx: ");
            int from = UserInterface.controllaScelta(Integer.MAX_VALUE);
            Settlement s1 = mapG.getNode(from);
            System.out.println("to indx: ");
            int to = UserInterface.controllaScelta(Integer.MAX_VALUE);
            Settlement s2 = mapG.getNode(to);
            System.out.println(vG.getFuel( s1, s2));

            System.out.println("Rifai ctrl 1=si , 0 = no: ");
            scelta = UserInterface.controllaScelta(2);
        }while(scelta == 1);
    }
}
