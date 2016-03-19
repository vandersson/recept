package recept.domain.recept;

import recept.domain.service.Searchable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vda
 */
public class Recept implements Searchable {

    private String id = "1";
    private String beskrivning = "Chef d'assino lagede denne rætt førsta gången 1921 til jet-kungen av egypten";
    private String titel = "Pasta med sås";
    private List<Ingrediens> ingredienser = new ArrayList<>();
    {
        ingredienser.add(new Ingrediens());
    }
    private Instruktion instruktion = new Instruktion();

    public String getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public List<Ingrediens> getIngredienser() {
        return ingredienser;
    }

    public String getInstruktion() {
        return instruktion.getInstruktion();
    }

    class Instruktion {
        private String instruktion = "Blanda pasta med såsen";

        String getInstruktion() {
            return instruktion;
        }
    }
}
