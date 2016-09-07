package javapocalypse.common.dto;

import com.google.common.base.MoreObjects;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String library;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String authors;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String oldPrice;

    @Getter
    @Setter
    private String newPrice;

    @Getter
    @Setter
    private String tag;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(BookDTO.class)
                .add("id", id)
                .add("library", library)
                .add("title", title)
                .add("authors", authors)
                .add("description", description)
                .add("oldPrice", oldPrice)
                .add("newPrice", newPrice)
                .add("tag", tag)
                .toString();
    }

}
