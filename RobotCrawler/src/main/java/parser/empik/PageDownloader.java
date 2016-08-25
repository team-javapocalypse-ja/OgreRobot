package parser.empik;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Optional;

public class PageDownloader {

    public Optional<Document> downloadPage(String url) {
        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            document = null;
        }

        return Optional.ofNullable(document);
    }

}
