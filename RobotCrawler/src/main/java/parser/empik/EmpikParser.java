package parser.empik;

import model.BookData;

import java.util.List;

public class EmpikParser {

    private final PageDownloader pageDownloader;

    public EmpikParser(PageDownloader pageDownloader) {
        this.pageDownloader = pageDownloader;
    }

    public List<BookData> parse() {
        PromotionsPageParser promotionsPageParser = new PromotionsPageParser(pageDownloader);
        CategoryPageParser categoryPageParser = new CategoryPageParser(pageDownloader);
        BookPageParser bookPageParser = new BookPageParser(pageDownloader);

        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(categoryPageUrls);
        return bookPageParser.extractBooks(bookPageUrls);
    }

}
