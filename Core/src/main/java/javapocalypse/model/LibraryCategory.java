package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "library_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCategory implements Serializable {

    private static final long serialVersionUID = -1686717996947262932L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_category_id")
    private int id;

    @OneToOne(optional = false)
    private Library library;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToOne(optional = false)
    private Tag tag;

}
