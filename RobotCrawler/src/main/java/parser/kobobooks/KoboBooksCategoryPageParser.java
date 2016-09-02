package parser.kobobooks;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class KoboBooksCategoryPageParser {

    private KoboPageDownloader koboPageDownloader;

    public KoboBooksCategoryPageParser(KoboPageDownloader koboPageDownloader) {
        this.koboPageDownloader = koboPageDownloader;
    }

    public List<String> collectBooksUrls(String categoryUrl) {
        Document doc = koboPageDownloader.getDocument(categoryUrl).get();
        return collectAllBooksUrls(doc.getElementsByClass("item-info"));
    }

    private List<String> collectAllBooksUrls(Elements categoryElements) {
        return categoryElements.parallelStream().map(element -> element.getElementsByClass("title")
                .first()
                .select("a")
                .attr("href")).collect(Collectors.toList());
    }
}

