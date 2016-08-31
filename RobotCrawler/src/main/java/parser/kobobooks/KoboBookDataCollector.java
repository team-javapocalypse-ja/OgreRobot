package parser.kobobooks;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Optional;

public class KoboBookDataCollector<T extends Document> {
    private static final String KOBO_BOOKS = "kobobooks";

    public String titleFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h1").select("h1").last().text())
                .orElse(null);
    }

    public String authorFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-info"))
                .map(elements -> elements.tagName("h2").select("h2").last().text())
                .orElse(null);
    }

    public String descriptionFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("synopsis-description-all"))
                .map(Elements::text)
                .orElse(null);
    }

    public String priceFrom(T element) { return element.getElementsByClass("price-area").text(); }

    public String urlFrom(T element) {
        return Optional.ofNullable(element.getElementsByClass("item-primary-metadata"))
                .map(elements -> elements.select("meta[property=url]").attr("content"))
                .orElse(null);
    }

    public String libraryFrom(T element) { return KOBO_BOOKS; }

    public String tagFrom(T element) {


        return null;
    }

}
