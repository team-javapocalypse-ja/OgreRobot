package parser.ebookscom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.DocumentBuilder;
import parser.Parser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Responsible to parse the ebooks.com/category/...
 */
public class EBooksParser implements Parser<Element> {

    /**
     * All results in ebooks.com of a category are stored in the list,
     * that are inside the table by id lblResults.
     *
     * @param document - The document could be build by the {@link DocumentBuilder}
     * @return - the list of {@link Element}
     */
    @Override
    public List<Element> parse(Document document) {
        return document.select("#lblResults li").stream().filter(e->
                e.toString().contains("color:red; text-decoration:line-through"))
                .collect(Collectors.toList());
    }
}
