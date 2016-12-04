package pcbuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Component {

    int _id;
    String name;
    String type;
    List<Connector> connectors;
    Map<String,String> metadata;


    public Component() {
        this._id = -1;
        this.name = "null";
        this.type = "null";
        this.connectors = new LinkedList<>();
        this.metadata = new HashMap<String,String>();
    }

    public Component(int id, String name,String type,List<Connector> connectors,Map<String,String> metadata) {
        this._id = id;
        this.name = name;
        this.type = type;
        this.connectors = connectors;
        this.metadata = metadata;
    }


}
