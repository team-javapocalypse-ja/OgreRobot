package javapocalypse.core.model.entities;

import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    private Library library;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "authors", nullable = false)
    private String authors;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "old_price", nullable = false)
    private String oldPrice;

    @Column(name = "new_price", nullable = false)
    private String newPrice;

    @Column(name = "tag", nullable = false)
    private String tag;

    public Book() {
    }

    public Book(
            Library library,
            String title,
            String authors,
            String description,
            String oldPrice,
            String newPrice,
            String tag) {
        this.library = library;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Book.class)
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
