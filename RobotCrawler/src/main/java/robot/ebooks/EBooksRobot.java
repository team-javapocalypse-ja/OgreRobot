package robot.ebooks;

import model.BookData;
import model.BookTag;
import model.Library;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.DocumentBuilder;
import parser.Parser;
import parser.ebookscom.BookDataFactory;
import parser.ebookscom.EBooksDataCollector;
import parser.ebookscom.EBooksParser;
import robot.BookTagUtil;

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

    public final BookTag category;
    public final BookTagUtil tagUtil;

    List<BookData> theList;

    public EBooksRobot(BookTag category, BookTagUtil tagUtil) {
        this.category = category;
        this.tagUtil = tagUtil;
    }

    @Override
    public List<BookData> call() throws Exception {
        startSearch();
        return theList;
    }

    private void searchOne(String category) {
        Optional<Document> documentOptional = DocumentBuilder
                .builder()
                .urlPath(LIBRARY_CATEGORY_URL.concat(category))
                .build()
                .buildFromUrl();

        if (!documentOptional.isPresent()) {
            return;
        }

        Parser<Element> parser = new EBooksParser();
        theList =
                BookDataFactory.newListBookData(parser.parse(documentOptional.get()), new EBooksDataCollector(this.category.toString()));

    }

    private void startSearch(){
        tagUtil.tagNamesOf(category, Library.E_BOOKS).forEach(this::searchOne);
    }

}
