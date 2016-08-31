package robot.ebooks;

import model.BookData;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.DocumentBuilder;
import parser.Parser;
import parser.ebookscom.BookDataFactory;
import parser.ebookscom.EBookCategory;
import parser.ebookscom.EBooksDataCollector;
import parser.ebookscom.EBooksParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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

    private void startSearch(){
        try {
            Document document = DocumentBuilder
                    .builder()
                    .urlPath(LIBRARY_CATEGORY_URL.concat(category.toString()))
                    .build()
                    .buildFromUrl();

            Parser<Element> parser = new EBooksParser();
            theList =
                    BookDataFactory.newListBookData(parser.parse(document), new EBooksDataCollector(),category.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
