package javapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "history_searches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorySearch implements Serializable {

    private static final long serialVersionUID = 1247475954814182295L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_search_id")
    private int id;

    @Column(name = "date")
    private Date date;

    @OneToOne(optional = false)
    private Library library;

    @OneToOne(optional = false)
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;

}
