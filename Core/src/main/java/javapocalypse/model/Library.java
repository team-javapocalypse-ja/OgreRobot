package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libraries", schema = "robot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library implements Serializable {

    private static final long serialVersionUID = 573723168620221402L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

}
