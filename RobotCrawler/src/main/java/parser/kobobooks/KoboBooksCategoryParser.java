package parser.kobobooks;

import model.BookData;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;


public class KoboBooksCategoryParser {

    KoboPageDownloader koboPageDownloader;
    KoboBookDataCollector<Document> dataCollector;


    public KoboBooksCategoryParser(KoboPageDownloader koboPageDownloader, KoboBookDataCollector dataCollector) {
        this.koboPageDownloader = koboPageDownloader;
        this.dataCollector = dataCollector;
    }

    public List<BookData> collectBookData(List<String> booksUrls) {
        List<BookData> books = new ArrayList<>();
        for (String bookUrl : booksUrls) {
            Document document = koboPageDownloader.getDocument(bookUrl).get();
            books.add(BookData.builder()
                    .title(dataCollector.titleFrom(document))
                    .author(dataCollector.authorFrom(document))
                    .description(dataCollector.descriptionFrom(document))
                    .price(dataCollector.priceFrom(document))
                    .tag(dataCollector.tagFrom(document))
                    .library(dataCollector.libraryFrom(document))
                    .url(dataCollector.urlFrom(document)).build());
        }
        return books;
    }

}
