package recept.web;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import recept.domain.recept.Recept;
import recept.domain.service.SearchService;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @Author: vda
 */
@Controller
@RequestMapping("/recept")
public class ReceptController {

    private ControllerRegister controllerRegister;

    @Autowired
    private VelocityEngine engine;

    @Autowired
    private SearchService searchService;


    @Autowired
    public ReceptController(ControllerRegister controllerRegister) {
        this.controllerRegister = controllerRegister;
        controllerRegister.register(Recept.class, "recept");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getRecept(@PathVariable String id) {
        HashMap<String, Object> model = createModel(searchService.getRecept(id));
        return VelocityEngineUtils.mergeTemplateIntoString(this.engine, "templates/recept.vm", "UTF-8", model);
    }

    private HashMap<String, Object> createModel(Recept recept) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("titel", recept.getTitel());
        model.put("ingredienser", recept.getIngredienser()
                .stream()
                .map((x) -> new Ingrediens(x.getLivsmedel().getName(), Double.toString(x.getMangd().getStorlek()), x.getMangd().getEnhet()))
                .collect(Collectors.toList()));
        model.put("instruktion", recept.getInstruktion());
        model.put("beskrivning", recept.getBeskrivning());
        return model;
    }

    public class Ingrediens {
        private String namn;
        private String antal;
        private String enhet;

        private Ingrediens(String namn, String antal, String enhet) {
            this.namn = namn;
            this.antal = antal;
            this.enhet = enhet;
        }

        public String getNamn() {
            return namn;
        }

        public String getAntal() {
            return antal;
        }

        public String getEnhet() {
            return enhet;
        }
    }
}
