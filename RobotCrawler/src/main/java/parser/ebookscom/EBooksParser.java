package parser.ebookscom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.Parser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ehsan on 25.08.16.
 */
public class EBooksParser implements Parser<Element> {

    @Override
    public List parse(Document document) {
        // all results. in ebooks.com the result of a category are stored int the list,
        // that are int he table by id lblResults
        return document.select("#lblResults li").stream().filter(e->
                e.toString().contains("color:red; text-decoration:line-through"))
                .collect(Collectors.toList());
    }
}
