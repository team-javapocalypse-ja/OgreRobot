package parser.kobobooks;


import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import parser.DocumentBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
public class CategoryPageParser {

    public List<String> collectBooksUrls(String baseUrl, List<String> categoriesUrls) throws IOException {
        return categoriesUrls.parallelStream()
                .map(category -> DocumentBuilder.builder().urlPath(baseUrl.concat(category)).build().buildFromUrl())
                .filter(Optional::isPresent)
                .flatMap(document -> collectBooksUrlForCategory(document.get()).stream())
                .collect(Collectors.toList());
    }

    private List<String> collectBooksUrlForCategory(Document document) {
        return extractBookUrl(document.getElementsByClass("item-info"));
    }

    private List<String> extractBookUrl(Elements categoryElements) {
        return categoryElements.parallelStream().map(element -> element.getElementsByClass("title")
                .first()
                .select("a")
                .attr("href")).collect(Collectors.toList());
    }
}

