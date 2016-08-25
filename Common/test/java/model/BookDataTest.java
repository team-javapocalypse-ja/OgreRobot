package model;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by ehsan on 25.08.16.
 */
public class BookDataTest {

    /**
     * This is a test to test if the builder works properly and set all fields.
     * The builder must be modify if the {@link BookData} changes.
     */
    @Test
    public void toTestIfTheBuilderReturnValidObject(){
        BookData.BookDataBuilder builder = new BookData.BookDataBuilder();

        builder.setProfile("test").
                setTitle("test").
                setUrl("test").
                setLibrary("test").
                setAuthor("test").
                setDescription("test").
                setPrice("0");

        String validString = "BookData{" +
                "title='" + "test" + '\'' +
                ", author='" + "test" + '\'' +
                ", description='" + "test" + '\'' +
                ", price='" + "0" + '\'' +
                ", library='" + "test" + '\'' +
                ", tag='" + "test" + '\'' +
                ", url='" + "test" + '\'' +
                '}';

        assertEquals(builder.build().toString(), validString);
    }

}
