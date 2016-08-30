package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

/**
 * Class responsible to build the data of books that we need
 */
@Builder
@ToString
public class BookData {

    /**
     * The {@link org.springframework.web.client.RestTemplate} uses this constructor
     * to build the object after parsing the json
     */
    @JsonCreator
    public BookData(
            @JsonProperty("title") String title,
            @JsonProperty("author") String author,
            @JsonProperty("description") String description,
            @JsonProperty("price") String price,
            @JsonProperty("library") String library,
            @JsonProperty("tag") String tag,
            @JsonProperty("url") String url) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.library = library;
        this.tag = tag;
        this.url = url;


    }

    public String title;
    public String author;
    public String description;
    public String price;
    public String library;
    public String tag;
    public String url;

}
