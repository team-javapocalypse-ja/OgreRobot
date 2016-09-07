package robot.ebooks;

import model.BookData;
import model.EBookCategory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.DocumentBuilder;
import parser.Parser;
import parser.ebookscom.BookDataFactory;
import parser.ebookscom.EBooksDataCollector;
import parser.ebookscom.EBooksParser;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * The robot is looking for books per category.
 * I need to call more than one robot in parallel to tell them
 * find books for specified category. And I need to know what they found.
 * That's why I implement the {@link Callable}
 */
public class EBooksRobot implements Callable<List<BookData>> {

    private static final String LIBRARY_CATEGORY_URL = "http://www.ebooks.com/subjects/";

    public final EBookCategory category;

    List<BookData> theList;

    public EBooksRobot(EBookCategory category) {
        this.category = category;
    }

    @Override
    public List<BookData> call() throws Exception {
        startSearch();
        return theList;
    }

    private void startSearch() {
        Optional<Document> documentOptional = DocumentBuilder
                .builder()
                .urlPath(LIBRARY_CATEGORY_URL.concat(category.toString()))
                .build()
                .buildFromUrl();
        if (!documentOptional.isPresent()) {
            return;
        }

        Parser<Element> parser = new EBooksParser();
        theList =
                BookDataFactory.newListBookData(parser.parse(documentOptional.get()), new EBooksDataCollector(), category
                        .toString());

    }

}
