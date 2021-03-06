package parser.empik;

import model.BookData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpikParser {

    private final PromotionsPageParser promotionsPageParser;
    private final CategoryPageParser categoryPageParser;
    private final BookPageParser bookPageParser;

    public EmpikParser(
            PromotionsPageParser promotionsPageParser,
            CategoryPageParser categoryPageParser,
            BookPageParser bookPageParser) {
        this.promotionsPageParser = promotionsPageParser;
        this.categoryPageParser = categoryPageParser;
        this.bookPageParser = bookPageParser;
    }

    public Map<String, List<BookData>> parse() {
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(categoryPageUrls);
        List<BookData> books = bookPageParser.extractBooks(bookPageUrls);

        return books.stream().collect(Collectors.groupingBy(b -> b.tag));
    }

}
