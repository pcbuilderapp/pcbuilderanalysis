package pcbuilder;

public class Component {

    private final int _id;
    private final String name;

    public Component() {
        this._id = 10;
        this.name = "Piet Patat";
    }

    public Component(int id, String name) {
        this._id = id;
        this.name = name;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return name;
    }
}
