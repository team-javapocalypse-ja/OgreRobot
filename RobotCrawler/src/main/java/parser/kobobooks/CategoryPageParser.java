package parser.kobobooks;


import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import parser.DocumentBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CategoryPageParser {

    private static final String baseUrl = "https://store.kobobooks.com";

    public List<String> collectBooksUrls(String categoryUrl) throws IOException {
        Document doc = null;
        log.debug("Start collecting books URLs for category");
        doc = DocumentBuilder.builder().urlPath(baseUrl.concat(categoryUrl)).build().buildFromUrl();

        return collectAllBooksUrls(doc.getElementsByClass("item-info"));
    }

    private List<String> collectAllBooksUrls(Elements categoryElements) {
        return categoryElements.parallelStream().map(element -> element.getElementsByClass("title")
                .first()
                .select("a")
                .attr("href")).collect(Collectors.toList());
    }
}

