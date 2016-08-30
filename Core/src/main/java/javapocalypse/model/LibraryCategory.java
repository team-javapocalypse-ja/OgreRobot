package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "library_categories", schema = "robot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCategory implements Serializable {

    private static final long serialVersionUID = -1686717996947262932L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_category_id")
    private int id;

    @OneToOne(optional = false)
    private Library library;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToOne(optional = false)
    private Tag tag;

}
