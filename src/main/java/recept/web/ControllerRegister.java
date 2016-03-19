package recept.web;

import org.springframework.stereotype.Component;
import recept.domain.service.Searchable;

import java.util.HashMap;

/**
 * @Author: vda
 */
@Component
public class ControllerRegister {

    private static final String HREF_FORMAT = "/%s/%s";

    private HashMap<Class<? extends Searchable>, String> mappings = new HashMap<>();


    public ControllerRegister register(Class<? extends Searchable> concept, String url) {
        mappings.put(concept, url);
        return this;
    }

    public String getUrlFor(Class<? extends Searchable> concept, String id) {
        String typeUrl = mappings.getOrDefault(concept, "unhandled");
        return String.format(HREF_FORMAT,typeUrl, id);
    }
}
