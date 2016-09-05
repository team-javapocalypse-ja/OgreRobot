package parser.kobobooks;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.BookDataCollector;

import java.util.Optional;

public class KoboBookDataCollector implements BookDataCollector<Document> {
    private static final String KOBO_BOOKS = "kobobooks";

    public String titleFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h1").select("h1"))
                .map(Elements::last)
                .map(Element::text)
                .orElse(null);
    }

    public String authorFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h2").select("h2"))
                .map(Elements::last)
                .map(Element::text)
                .orElse(null);
    }

    public String descriptionFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("synopsis-description-all"))
                .map(Elements::text)
                .orElse(null);
    }

    public String priceFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("price-area"))
                .map(Elements::text)
                .orElse(null);
    }

    @Override public String oldPriceFrom(Document document) {
        return null;
    }

    public String urlFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("item-primary-metadata"))
                .map(elements -> elements.select("meta[property=url]").attr("content"))
                .orElse(null);
    }

    public String libraryFrom(Document document) { return KOBO_BOOKS; }

    public String tagFrom(Document document) {
        return Optional.ofNullable(document.getElementsByClass("category-rankings"))
                .map(elements -> document.getElementsByClass("category-rankings").select("meta[property=genre]").attr("content"))
                .orElse(null);
    }

}
