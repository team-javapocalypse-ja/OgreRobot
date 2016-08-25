package parser.empik;

import model.BookData;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class BookPageParser {

    private final PageDownloader pageDownloader;

    public BookPageParser(PageDownloader pageDownloader) {
        this.pageDownloader = pageDownloader;
    }

    public List<BookData> extractBooks(List<String> bookPageUrls) {
        List<BookData> booksData = bookPageUrls.parallelStream()
                .map(pageDownloader::downloadPage)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::extractBookData)
                .collect(Collectors.toList());

        return booksData;
    }

    private BookData extractBookData(Document document) {
        String title = document.getElementsByAttributeValue("itemProp", "name").first().text();
        String author = document.getElementsByAttributeValue("itemProp", "author").first().text();
        String description = document.getElementsByClass("longDescription").first().text();

        Element prices = document.getElementsByClass("ProductOtherInfo220").first();
        String currentPrice = prices.getElementsByClass("currentPrice").first().text();
        String oldPrice = prices.getElementsByClass("oldPrice").first().text();

        Elements elements = document.getElementsByClass("productLocalizer").first().getElementsByTag("a");
        String tag = elements.last().text();

        return BookData.builder()
                .title(title)
                .author(author)
                .description(description)
                .price("Current: ".concat(currentPrice).concat(", Old: ").concat(oldPrice))
                .library("Empik")
                .tag(tag)
                .url(document.baseUri())
                .build();
    }

}
