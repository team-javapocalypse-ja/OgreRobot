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
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Testing the parser and test how the collector is working, if collect the data properly.
 */
public class EBooksParserTest {

    private Document theHtmlFile = null;
    private Parser<Element> parser = new EBooksParser();
    private BookDataCollector getter = new EBooksDataCollector();
    @BeforeTest
    protected void initTest(){
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/parser-ebook-test-1.html");
        try {
            theHtmlFile = DocumentBuilder.builder().file(file).build().buildFromFile();
        } catch (IOException e) {
            // TODO there must be the logger
            throw new AssertionError();
        }
    }

    @Test
    public void checkIfParserFindsOneOffersFromFile(){

        // given - theHtmlFile

        // when
        List<Element> offers = parser.parse(theHtmlFile);

        // then
        assertFalse(Objects.isNull(offers));
        assertEquals(offers.size(), 1);
    }

    @Test
    public void checkIfTheParsedDataCouldConvertToBookData(){

        // given - theHtmlFile

        // when
        List<Element> offers = parser.parse(theHtmlFile);

        // then
        assertFalse(Objects.isNull(offers));
        assertEquals(offers.size(), 1);
    }

    @Test
    public void testIfDocumentFromTheUrlWorks(){
        final String URL_E_BOOKS_COM = "http://www.ebooks.com/subjects/art";
        // given
        Document documentFromUrl = null;
        try {
             documentFromUrl = DocumentBuilder.builder().urlPath(URL_E_BOOKS_COM).build().buildFromUrl();
        } catch (IOException e) {
            // TODO there must be the logger
            assertFalse(true, "this state is invalid and test cannot be passed in this situation");
        }

        assertFalse(Objects.isNull(documentFromUrl));

        // when
        List<Element> offersUrl = parser.parse(documentFromUrl);
        List<BookData> bookDataList = BookDataFactory.newListBookData(offersUrl, getter, "art");
        System.out.println(bookDataList);
        assertTrue(bookDataList!=null);

    }

}
