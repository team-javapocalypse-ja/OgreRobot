package parser.kobobooks;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

public class KoboBookDataCollector<T extends Document> {
    private static final String KOBO_BOOKS = "kobobooks";

    public String titleFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h1").select("h1"))
                .map(Elements::last)
                .map(Element::text)
                .orElse(null);
    }

    public String authorFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h2").select("h2"))
                .map(Elements::last)
                .map(Element::text)
                .orElse(null);
    }

    public String descriptionFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("synopsis-description-all"))
                .map(Elements::text)
                .orElse(null);
    }

    public String priceFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("price-area"))
                .map(Elements::text)
                .orElse(null);
    }

    public String urlFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-primary-metadata"))
                .map(elements -> elements.select("meta[property=url]").attr("content"))
                .orElse(null);
    }

    public String libraryFrom(T element) { return KOBO_BOOKS; }

    public String tagFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("category-rankings"))
                .map(elements -> element.getElementsByClass("category-rankings").select("meta[property=genre]").attr("content"))
                .orElse(null);
    }

}
