package parser.empik;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Optional;

@Log4j2
public class PageDownloader {

    public Optional<Document> downloadPage(String url) {
        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.error("Error during establishing connection to ".concat(url));
            document = null;
        }

        return Optional.ofNullable(document);
    }

}
