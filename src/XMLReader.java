import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class XMLReader {
    private static final String INIT_ERROR = "Errore nell'inizializzazione del reader:";
    private static final String CITY = "city";
    private static final String LINK = "link";
//fixme



    /**
     * classe di utilità che inizializza un nuovo XMLStreamReader
     *
     * @param input_file file di input da leggere
     * @return l'istanza del nuovo StreamReader inizializzato
     */
    private static XMLStreamReader streamReaderInit(String input_file) {
        XMLInputFactory factory = null;
        XMLStreamReader reader = null;
        try {
            factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(input_file, new FileInputStream(input_file));
        } catch (Exception e) {
            System.out.println(INIT_ERROR);
            System.out.println(e.getMessage());
        }
        return reader;
    }


    //legge attributi di Settlement
    public static ArrayList<Settlement> readCity(String input_file) throws XMLStreamException {

        ArrayList<Settlement> settlements = new ArrayList<>();
        ArrayList<Integer> links = new ArrayList<>();

        XMLStreamReader reader = streamReaderInit(input_file);
        Settlement s = null; //crea un nuovo Settlement di appoggio inizialmente null

        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT ) {
                switch (reader.getLocalName()) {
                    case CITY:
                    { if (s == null)//controlla se s non è stata inzializzata e in tal caso la inizializza con una nuova istanza di Settlement
                             s = new Settlement(); //crea una nuova Settlement di appoggio e ne raccoglie i dati
                        s.setId(Integer.parseInt(reader.getAttributeValue(0)));
                        s.setName(reader.getAttributeValue(1));
                        s.setX(Integer.parseInt(reader.getAttributeValue(2)));
                        s.setY(Integer.parseInt(reader.getAttributeValue(3)));
                        s.setHeight(Integer.parseInt(reader.getAttributeValue(4)));
                        break;
                    }
                    case LINK:
                    {   if (s == null)//controlla se s non è stata inzializzata e in tal caso la inizializza con una nuova istanza di Settlement
                            s = new Settlement();
                        reader.next();
                        while(reader.getLocalName().equals(LINK)){
                          //  System.out.println("City: " + input_file.getDocumentElement().getChildNodes().item(0).getFirstChild().getChildNodes().item(0).getAttributes().getNamedItem("to").getNodeValue());
                            links.add(Integer.parseInt(reader.getAttributeValue(0)));
                        }
                    }

                }





                /*if (reader.getLocalName().equals(LINK)){
                        if (s == null;
                            s = new Settlement();
                       // int x= (Integer.parseInt(reader.getAttributeValue(0)));
                        //links.add(x);
                        //reader.next();
            }*/
                //s.addConnection(links);
                settlements.add(s);
                s = null;
                links = null;

        }//end if 1
            reader.next();
        }
        return settlements;
    }

    public static ArrayList<Integer> readLinks(String input_file) throws XMLStreamException  {
          /* case LINK:
                        ArrayList<Integer> links = new ArrayList<>();
                        if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                        while (reader.hasNext()) {
                            if (s == null)//se, per qualche oscuro motivo s non è stata inizializzata, la inizializzo
                                s = new Settlement();
                            reader.next();
                            int x= (Integer.parseInt(reader.getAttributeValue(0)));
                            links.add(x);
                        }*/

        // s.addConnection(links);
      return null;
    }

}
