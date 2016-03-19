package recept.domain.service;

import recept.domain.recept.Recept;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: vda
 */
public interface SearchService {

    SearchResult find(String query);

    Recept getRecept(String id);

    class SearchResult {

        List<SearchResultItem> items = new ArrayList<>();

        public SearchResult() {

        }

        private SearchResult(List<SearchResultItem> items) {
            this.items = items;
        }

        public SearchResult add(String id, Class<? extends Searchable> type, String name) {
            items.add(new SearchResultItem(id, type, name));
            return this;
        }

        public Stream<SearchResultItem> stream() {
            return items.stream();
        }

        public SearchResult filter(Predicate<? super SearchResultItem> predicate) {
            return new SearchResult(items.stream().filter(predicate).collect(Collectors.toList()));
        }

        public class SearchResultItem {
            private final String id;
            private final Class<? extends Searchable> type;
            private final String name;

            SearchResultItem(String id, Class<? extends Searchable> type, String name) {
                this.id = id;
                this.type = type;
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public Class<? extends Searchable> getType() {
                return type;
            }

            public String getName() {
                return name;
            }
        }
    }
}
