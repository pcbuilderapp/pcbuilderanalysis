package pcbuilder;

import java.util.List;

/**
 * Created by Stefan Ladage on 4-12-2016.
 */
public class PCConfiguration {
    List<Integer> components;

    Component getMotherboard() {
        final Component c = ComponentController.getComponentFromList(components,"motherboard");
        return c;
    }

    Component getGPU() {
        final Component c = ComponentController.getComponentFromList(components,"gpu");
        return c;
    }

    Component getCPU() {
        final Component c = ComponentController.getComponentFromList(components,"cpu");
        return c;
    }

    Component getMemory() {
        final Component c = ComponentController.getComponentFromList(components,"memory");
        return c;
    }

    Component getStorage() {
        final Component c = ComponentController.getComponentFromList(components,"storage");
        return c;
    }

    Component getPSU() {
        final Component c = ComponentController.getComponentFromList(components,"psu");
        return c;
    }

    Component getCase() {
        final Component c = ComponentController.getComponentFromList(components,"case");
        return c;
    }
}
