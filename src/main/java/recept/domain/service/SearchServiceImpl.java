package recept.domain.service;

import org.springframework.stereotype.Component;
import recept.domain.recept.Ingrediens;
import recept.domain.recept.Recept;

/**
 * @Author: vda
 */
@Component
class SearchServiceImpl implements SearchService {

    private SearchResult allResults = new SearchResult()
            .add("1", Recept.class, "mock recept 1")
            .add("2", Recept.class, "mock recept 2")
            .add("3", Ingrediens.class, "mock ingrediense 1")
            .add("4", Ingrediens.class, "mock verktyg 1")
            .add("5", Ingrediens.class, "mock køk 1")
            .add("6", Recept.class, "test recept 2")
            .add("7", Recept.class, "test recept 3");

    @Override
    public SearchResult find(String query) {
        return allResults.filter((x) -> x.getName().contains(query));
    }

    @Override
    public Recept getRecept(String id) {
        return new Recept();

    }
}
