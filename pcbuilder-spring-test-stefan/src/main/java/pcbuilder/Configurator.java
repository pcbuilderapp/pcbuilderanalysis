package pcbuilder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Configurator {

    @RequestMapping("/getcomponent")
    public Component getComponent(@RequestParam(value="id", defaultValue="0") int id, @RequestParam(value="name", defaultValue="Pietje Puk") String name) {
        return new Component(id, name);
    }

    @RequestMapping("/putcomponent")
    public Component putComponent(@RequestBody Component component) {
        return component;
    }

}
