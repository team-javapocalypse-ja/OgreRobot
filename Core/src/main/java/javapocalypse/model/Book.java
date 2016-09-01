package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = -9160665520869542107L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Author> authors;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "old_price")
    private String oldPrice;

    @Column(name = "new_price", nullable = false)
    private String newPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

}
