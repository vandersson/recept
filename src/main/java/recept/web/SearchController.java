package recept.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import recept.domain.service.SearchService;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author: vda
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    ControllerRegister controllerRegister;

    @Autowired
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SearchRespons> search(@RequestParam(name = "q", required = true) String query) {
        SearchService.SearchResult result = searchService.find(query);
        return convertToResponse(result);
    }

    private List<SearchRespons> convertToResponse(SearchService.SearchResult input) {
        return input
                .stream()
                .map((x) -> new SearchRespons(x.getName(), controllerRegister.getUrlFor(x.getType(), x.getId())))
                .collect(Collectors.toList());
    }

    class SearchRespons {
        private final String text;
        private final String href;

        public SearchRespons(String text, String href) {
            this.text = text;
            this.href = href;
        }

        public String getText() {
            return text;
        }

        public String getHref() {
            return href;
        }
    }


}
