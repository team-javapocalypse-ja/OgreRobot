package model;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by ehsan on 25.08.16.
 */
public class BookDataTest {

    /**
     * This is a test to test if the builder works properly and set all fields.
     */
    @Test
    public void toTestIfTheBuilderReturnValidObject(){
        BookData bookData = BookData.builder().tag("test").
                title("test").
                url("test").
                library("test").
                author("test").
                description("test").
                price("0").build();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(bookData.title, "test");
        softAssert.assertEquals(bookData.url, "test");
        softAssert.assertEquals(bookData.library, "test");
        softAssert.assertEquals(bookData.author, "test");
        softAssert.assertEquals(bookData.description, "test");
        softAssert.assertEquals(bookData.price, "0");

        softAssert.assertAll();

    }

}
