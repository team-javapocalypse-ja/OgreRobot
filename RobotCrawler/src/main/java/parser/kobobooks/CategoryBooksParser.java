package parser.kobobooks;

import model.BookData;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;


public class CategoryBooksParser {

    KoboPageDownloader koboPageDownloader;
    KoboBookDataCollector<Document> dataCollector;


    public CategoryBooksParser(KoboPageDownloader koboPageDownloader, KoboBookDataCollector dataCollector) {
        this.koboPageDownloader = koboPageDownloader;
        this.dataCollector = dataCollector;
    }

    public List<BookData> collectBookData(List<String> booksUrls) {
        List<BookData> books = new ArrayList<>();
        for (String bookUrl : booksUrls) {
            Document doc = koboPageDownloader.getDocument(bookUrl).get();
            books.add(BookData.builder()
                    .title(dataCollector.titleFrom(doc))
                    .author(dataCollector.authorFrom(doc))
                    .description(dataCollector.descriptionFrom(doc))
                    .library(dataCollector.libraryFrom(doc))
                    .url(dataCollector.urlFrom(doc)).build());
        }
        return books;
    }

}
