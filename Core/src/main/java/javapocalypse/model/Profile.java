package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "profiles", schema = "robot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {

    private static final long serialVersionUID = -3892341051445749965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

}
