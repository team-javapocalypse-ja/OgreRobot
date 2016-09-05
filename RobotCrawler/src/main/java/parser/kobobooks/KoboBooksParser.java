package parser.kobobooks;

import model.BookData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KoboBooksParser {

    private static final String freeBooksUrl = "/p/free-ebooks";
    KoboBooksPageParser booksPageParser;
    KoboBooksCategoryPageParser booksCategoryPageParser;
    KoboBooksCategoryParser booksCategoryParser;
    private KoboPageDownloader pageDownloader;

    public KoboBooksParser(KoboPageDownloader pageDownloader) {
        this.pageDownloader = pageDownloader;
        this.booksPageParser = new KoboBooksPageParser(pageDownloader);
        this.booksCategoryPageParser = new KoboBooksCategoryPageParser(pageDownloader);
        this.booksCategoryParser = new KoboBooksCategoryParser(pageDownloader, new KoboBookDataCollector());
    }

    public Map<String, List<BookData>> parse() {
        List<String> categoriesUrls = booksPageParser.getFreeBooksCategoriesUrls(freeBooksUrl);
        List<String> booksUrls = booksCategoryPageParser.collectBooksUrls(categoriesUrls.get(0));

        return booksCategoryParser.collectBookData(booksUrls)
                .parallelStream()
                .collect(Collectors.groupingBy(b -> b.tag));
    }
}
