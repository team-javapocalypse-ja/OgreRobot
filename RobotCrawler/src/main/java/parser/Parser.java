package parser;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by ehsan on 25.08.16.
 */
public interface Parser<T> {
    List<T> parse(Document document);
}
