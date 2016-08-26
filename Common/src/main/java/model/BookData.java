package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

/**
 * Class responsible to build the data of books that we need
 */
@Builder
@AllArgsConstructor
@ToString
public class BookData {

    public final String title;
    public final String author;
    public final String description;
    public final String price;
    public final String library;
    public final String tag;
    public final String url;

}
