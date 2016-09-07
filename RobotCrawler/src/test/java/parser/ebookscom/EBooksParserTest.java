package parser.ebookscom;

import model.BookData;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import parser.BookDataCollector;
import parser.DocumentBuilder;
import parser.Parser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.testng.Assert.*;

/**
 * Testing the parser and test how the collector is working, if collect the data properly.
 */
public class EBooksParserTest {

    private Document theHtmlFile = null;
    private Parser<Element> parser = new EBooksParser();
    private BookDataCollector getter = new EBooksDataCollector();

    @BeforeTest
    protected void initTest() {
        try {
            Path path = Paths.get(getClass().getResource("/parser-ebook-test-1.html").toURI());
            File file = new File(path.toUri());
            theHtmlFile = DocumentBuilder.builder().file(file).build().buildFromFile();
        } catch (IOException | URISyntaxException e) {
            // TODO there must be the logger
            throw new AssertionError();
        }
    }

    @Test
    public void checkIfParserFindsOneOffersFromFile() {

        // given - theHtmlFile

        // when
        List<Element> offers = parser.parse(theHtmlFile);

        // then
        assertFalse(Objects.isNull(offers));
        assertEquals(offers.size(), 1);
    }

    @Test
    public void checkIfTheParsedDataCouldConvertToBookData() {

        // given - theHtmlFile

        // when
        List<Element> offers = parser.parse(theHtmlFile);

        // then
        assertFalse(Objects.isNull(offers));
        assertEquals(offers.size(), 1);
    }

    /**
     * This must be run as integration test
     */
    public void testIfDocumentFromTheUrlWorks() {
        final String URL_E_BOOKS_COM = "http://www.ebooks.com/subjects/art";
        // given
        Optional<Document> documentOptional = DocumentBuilder.builder().urlPath(URL_E_BOOKS_COM).build().buildFromUrl();

        assertFalse(!documentOptional.isPresent());

        // when
        List<Element> offersUrl = parser.parse(documentOptional.get());
        List<BookData> bookDataList = BookDataFactory.newListBookData(offersUrl, getter, "art");
        System.out.println(bookDataList);
        assertTrue(bookDataList != null);

    }

}
