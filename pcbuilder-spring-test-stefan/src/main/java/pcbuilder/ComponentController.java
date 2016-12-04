package pcbuilder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan Ladage on 4-12-2016.
 */

@RestController
public class ComponentController {
    @RequestMapping("/getComponents")
    public List<Component> getComponents(ComponentRequest request) {
        if (request.configuration.getMotherboard() != null) {
            // we have a motherboard, use it as our main filter
            return componentsWithConnectors(request.configuration.getMotherboard().connectors,request.type,request.filter);
        } else {
            // build a list of connectors for all current components
            List<Connector> connectors = new LinkedList<Connector>();
            for (Integer i : request.configuration.components) {
                Component c = getComponent(i);
                connectors.addAll(c.connectors);
            }
            List<Component> matchingMotherboards = componentsWithConnectors(connectors,"motherboard");
            // now build a list of connectors from the filtered list of motherboards
            connectors = new LinkedList<Connector>();
            for (Component c : matchingMotherboards) {
                connectors.addAll(c.connectors);
            }
            // return all matched items
            return componentsWithConnectors(connectors,request.type,request.filter);
        }
    }

    static public Component getComponent(int id) {
        return store.get(id);
    }

    static public Component getComponentFromList(List<Integer> components, String type) {
        Component c = new Component();
        for (Integer i : components) {
            c = getComponent(i);
            if (c.type == type) break;
        }
        return c;
    }

    static List<Component> componentsWithConnectors(List<Connector> connectors, String type) {
        // impl enkel voor test
        List<Component> components = new LinkedList<Component>();
        for (Component c : store.values()) {
            if (c.type != type) continue;
            if (c.connectors.containsAll(connectors)) {
                components.add(c);
            }
        }
        return components;
    }

    static List<Component> componentsWithConnectors(List<Connector> connectors, String type, String filter) {
        // impl enkel voor test
        List<Component> components = new LinkedList<Component>();
        for (Component c : store.values()) {
            if (c.type != type) continue;
            if (filter != "" && !c.name.contains(filter)) continue; // in het echt filter string in parts opdelen
            if (c.connectors.containsAll(connectors)) {
                components.add(c);
            }
        }
        return components;
    }

    // enkel voor test
    static Map<Integer,Component> store = new HashMap<Integer,Component>();
    static void populateTestData() {
        
    }
}
