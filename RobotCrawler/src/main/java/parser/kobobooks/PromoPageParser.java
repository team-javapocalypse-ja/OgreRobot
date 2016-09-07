package parser.kobobooks;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import parser.DocumentBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PromoPageParser {

    public List<String> getPromoCategoriesUrls(String url) throws IOException {
        Optional<Document> documentOptional = DocumentBuilder.builder().urlPath(url).build().buildFromUrl();
        if (!documentOptional.isPresent()) {
            return new ArrayList<>();
        }
        Elements elements = documentOptional.get().getElementsByClass("view-all-link");
        return elements.parallelStream()
                .map(element -> element.childNodes().get(1).attr("href"))
                .collect(Collectors.toList());
    }


}
