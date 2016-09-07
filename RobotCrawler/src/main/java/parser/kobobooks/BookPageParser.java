package parser.kobobooks;

import lombok.extern.log4j.Log4j2;
import model.BookData;
import org.jsoup.nodes.Document;
import parser.DocumentBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
public class BookPageParser {

    private KoboBooksDataCollector dataCollector;

    public BookPageParser(KoboBooksDataCollector dataCollector) {
        this.dataCollector = dataCollector;
    }

    public List<BookData> collectBookData(List<String> booksUrls) throws IOException {
        log.debug("Start collecting books data");
        return booksUrls.parallelStream()
                .map(book -> DocumentBuilder.builder().urlPath(book).build().buildFromUrl())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::buildBookDataEntry)
                .collect(Collectors.toList());
    }

    private BookData buildBookDataEntry(Document document) {
        BookData bookData = BookData.builder()
                .title(dataCollector.titleFrom(document))
                .author(dataCollector.authorFrom(document))
                .description(dataCollector.descriptionFrom(document))
                .price(dataCollector.priceFrom(document))
                .tag(dataCollector.tagFrom(document))
                .library(dataCollector.libraryFrom(document))
                .url(dataCollector.urlFrom(document)).build();
        log.debug("Collected book: ".concat(bookData.toString()));
        return bookData;
    }

}
