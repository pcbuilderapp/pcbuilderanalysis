package pcbuilder;

import java.util.LinkedList;
import java.util.List;

public class Component {

    int _id;
    String name;
    String type;
    List<Connector> connectors;


    public Component() {
        this._id = -1;
        this.name = "null";
        this.type = "null";
        this.connectors = new LinkedList<>();
    }

    public Component(int id, String name,String type,List<Connector> connectors) {
        this._id = id;
        this.name = name;
        this.type = type;
        this.connectors = connectors;
    }


}
