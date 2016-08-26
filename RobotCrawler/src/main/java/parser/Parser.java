package parser;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Functional interface
 */
public interface Parser<T> {
    /**
     * Parser the document given as parameter
     * @param document - The document could be build by the {@link DocumentBuilder}
     * @return The parsed document as list type T, after overriding the method,
     * Do not forget to implement the {@link BookDataCollector} for the usage of {@link parser.ebookscom.BookDataFactory}
     */
    List<T> parse(Document document);
}
