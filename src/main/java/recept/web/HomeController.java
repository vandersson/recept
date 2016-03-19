package recept.web;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
public class HomeController {

    @Autowired
    private VelocityEngine engine;

    @RequestMapping("/")
    public @ResponseBody String home() {
        return VelocityEngineUtils.mergeTemplateIntoString(this.engine, "templates/home.vm", "UTF-8", new HashMap<>());
    }


}
