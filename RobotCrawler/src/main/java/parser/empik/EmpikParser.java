package parser.empik;

import model.BookData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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

    public List<BookData> parse() {
        return parse(new ArrayList<>());
    }

    public List<BookData> parse(List<String> categories) {
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(categoryPageUrls);
        List<BookData> booksData = bookPageParser.extractBooks(bookPageUrls);

        Predicate<BookData> categoryPredicate = new CategoryPredicate(categories);
        return booksData.stream().filter(categoryPredicate).collect(Collectors.toList());
    }

    private static class CategoryPredicate implements Predicate<BookData> {

        private final List<String> categories;

        public CategoryPredicate(List<String> categories) {
            this.categories = categories;
        }

        @Override
        public boolean test(BookData bookData) {
            if (categories.isEmpty()) {
                return true;
            }

            return categories.contains(bookData.tag);
        }

    }

}
