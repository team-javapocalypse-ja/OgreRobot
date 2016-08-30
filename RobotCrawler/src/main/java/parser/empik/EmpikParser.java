package parser.empik;

import javapocalypse.model.BookData;

import java.util.List;

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

    public List<BookData> parse() {
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(categoryPageUrls);
        return bookPageParser.extractBooks(bookPageUrls);
    }

}
