package parser.ebookscom;

import org.jsoup.nodes.Element;
import parser.BookDataCollector;

/**
 * To collect the data that the {@link EBooksParser}
 * parsed earlier.
 */
public class EBooksDataCollector implements BookDataCollector<Element> {

    private final String LIB_URL = "http://www.ebooks.com/";
    public String urlFrom(Element element){
        return element.select(".book-title a").attr("href");
    }

    @Override
    public String libraryFrom(Element element) {
        return LIB_URL;
    }

    @Override
    public String tagFrom(Element element) {
        return null;
    }

    public String titleFrom(Element element){
        return element.select(".book-title a").text();
    }

    public String authorFrom(Element element){
        return element.select(".author").text();
    }

    public String descriptionFrom(Element element){
        return element.select("p").text();
    }

    public String priceFrom(Element element){
        String str1 = element.select(".additional-info span span span").toString();
        return element.select(".additional-info span span")
                .toString().replace(str1,"")
                .replaceAll("<span>","")
                .replace("</span>","").trim();
    }
}
