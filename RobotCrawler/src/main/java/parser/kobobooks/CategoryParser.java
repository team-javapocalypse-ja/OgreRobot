package parser.kobobooks;

import lombok.extern.log4j.Log4j2;
import model.BookData;
import org.jsoup.nodes.Document;
import parser.DocumentBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CategoryParser {

    private static final String baseUrl = "https://store.kobobooks.com";
    KoboBooksDataCollector dataCollector;


    public CategoryParser(KoboBooksDataCollector dataCollector) {
        this.dataCollector = dataCollector;
    }

    public List<BookData> collectBookData(List<String> booksUrls) throws IOException {
        List<BookData> books = new ArrayList<>();
        log.debug("Start collecting books data");
        for (String bookUrl : booksUrls) {
            Document document = DocumentBuilder.builder().urlPath(baseUrl.concat(bookUrl)).build().buildFromUrl();
            BookData bookData = BookData.builder()
                    .title(dataCollector.titleFrom(document))
                    .author(dataCollector.authorFrom(document))
                    .description(dataCollector.descriptionFrom(document))
                    .price(dataCollector.priceFrom(document))
                    .tag(dataCollector.tagFrom(document))
                    .library(dataCollector.libraryFrom(document))
                    .url(dataCollector.urlFrom(document)).build();
            log.debug("Collected book: ".concat(bookData.toString()));
            books.add(bookData);
        }
        return books;
    }

}
