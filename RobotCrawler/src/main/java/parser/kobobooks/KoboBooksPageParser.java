package parser.kobobooks;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class KoboBooksPageParser {

    private KoboPageDownloader koboPageDownloader;

    public KoboBooksPageParser(KoboPageDownloader koboPageDownloader) {
        this.koboPageDownloader = koboPageDownloader;
    }

    public List<String> getFreeBooksCategoriesUrls(String freeBooksUrl) {
        Document doc = koboPageDownloader.getDocument(freeBooksUrl).get();
        Elements elements = doc.getElementsByClass("view-all-link");
        return elements.parallelStream().map(element -> element.childNodes().get(1).attr("href")).collect(Collectors.toList());
    }


}
