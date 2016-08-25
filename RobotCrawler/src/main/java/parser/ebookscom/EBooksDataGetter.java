package parser.ebookscom;

import org.jsoup.nodes.Element;
import parser.BookDataGetter;

/**
 * Created by ehsan on 25.08.16.
 */
public class EBooksDataGetter implements BookDataGetter<Element> {

    public String  getUrl(Element element){
        return element.select(".book-title a").attr("href");
    }

    @Override
    public String getLibrary(Element element) {
        return "http://www.ebooks.com/";
    }

    @Override
    public String getTag(Element element) {
        return null;
    }

    public String getTitle(Element element){
        return element.select(".book-title a").text();
    }

    public String getAuthor(Element element){
        return element.select(".author").text();
    }

    public String getDescription(Element element){
        return element.select("p").text();
    }

    public String getPrice(Element element){
        String str1 = element.select(".additional-info span span span").toString();
        return element.select(".additional-info span span")
                .toString().replace(str1,"")
                .replaceAll("<span>","")
                .replace("</span>","").trim();
    }
}
