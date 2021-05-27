import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class MainRovine {

    // private static final ArrayList<String> INPUT_FILES = new
    private static final String[] INPUT_FILES = {"test_file/PgAr_Map_5.xml",
            "test_file/PgAr_Map_12.xml",
            "test_file/PgAr_Map_50.xml",
            "test_file/PgAr_Map_200.xml",
            "test_file/PgAr_Map_2000.xml",
            "test_file/PgAr_Map_10000.xml"};

    private static final String FILE_PROVE = "test_file/PgAr_Map_5.xml";  //todo toglimi alla fine, per usare per prove


    public static void main(String[] args) throws XMLStreamException {
        ArrayList<Settlement> settlements = XMLReader.readMap(FILE_PROVE); //fixme forse non va bene senza new ctrl dopo

        //Vehicle aTerra = new GroundVehicle();


    }
}