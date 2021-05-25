import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MyMap{

    //find settlements by integer id
    private HashMap<Integer, Settlement> map;

    public MyMap() {
        this.map = new HashMap<>();
    }

    public void addNode(Settlement s){
        this.map.put(s.getId(), s);
    }

    public Settlement getNode(int index){
        return  this.map.get(index);
    }

    public int getNodesNum(){
        return this.map.size();
    }

    public Settlement getNodeByName(String name){
        for (Settlement s : map.values()) {
            if(s.equals(name))
                return s;
        }
        return null;
    }

    public Collection<Settlement> getNodes(){
        return this.map.values();
    }

}
