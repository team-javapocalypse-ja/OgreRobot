package parser.ebookscom;

import org.testng.annotations.Test;
import parser.DocumentBuilder;
import parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * This parser is responsible to parse data prom the
 */
public class EBooksParserTest {

    @Test
    public void checkIfCrawlerFindsOneOffersFromFile(){

        // given
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/parser-ebook-test-1.html");
        String tag = "art";


        // when
        Parser crawler = new EBooksParser();

        List offers = null;
        try {
            offers = crawler.parse(DocumentBuilder.builder().file(file).build().buildFromFile());
        } catch (IOException e) {
            // TODO there must be the logger
        }

        // then
        if(offers==null){
            // this state is invalid and test cannot be passed in this situation
            assertFalse(true);
        }else{
            assertEquals(offers.size(), 1);
        }
    }

}
