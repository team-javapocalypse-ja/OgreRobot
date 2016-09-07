package parser.kobobooks;

import lombok.extern.log4j.Log4j2;
import model.BookData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Log4j2
public class KoboBooksParser {

    private static final String baseUrl = "https://store.kobobooks.com";
    private static final String freeBooksUrl = "/p/free-ebooks";
    PromoPageParser booksPageParser;
    CategoryPageParser booksCategoryPageParser;
    BookPageParser booksCategoryParser;

    public KoboBooksParser() {
        this.booksPageParser = new PromoPageParser();
        this.booksCategoryPageParser = new CategoryPageParser();
        this.booksCategoryParser = new BookPageParser(new KoboBooksDataCollector());
    }

    public Map<String, List<BookData>> parse() {
        Map<String, List<BookData>> books = new TreeMap<>();
        try {
            List<String> categoriesUrls = booksPageParser.getPromoCategoriesUrls(baseUrl.concat(freeBooksUrl));

            List<String> booksUrls = booksCategoryPageParser.collectBooksUrls(baseUrl, categoriesUrls);

            books = booksCategoryParser.collectBookData(booksUrls)
                    .parallelStream()
                    .collect(Collectors.groupingBy(book -> book.tag));
        } catch (IOException e) {
            log.error("Error during parsing ".concat(e.getMessage()));
        } catch (Exception e) {

        }
        return books;
    }
}
