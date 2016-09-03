package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Builder;
import lombok.ToString;

/**
 * Data structure of book data
 */
@Builder
@ToString
@Immutable
public class BookData {

    /**
     * The {@link org.springframework.web.client.RestTemplate} uses this constructor
     * to build the object after parsing the json
     */
    @JsonCreator
    private BookData(
            @JsonProperty("title") String title,
            @JsonProperty("author") String author,
            @JsonProperty("description") String description,
            @JsonProperty("price") String price,
            @JsonProperty("oldPrice") String oldPrice,
            @JsonProperty("library") String library,
            @JsonProperty("tag") String tag,
            @JsonProperty("url") String url) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.library = library;
        this.tag = tag;
        this.url = url;


    }

    public final String title;
    public final String author;
    public final String description;
    public final String price;
    public final String oldPrice;
    public final String library;
    public final String tag;
    public final String url;

}
