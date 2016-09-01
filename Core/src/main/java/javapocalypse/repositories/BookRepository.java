package javapocalypse.repositories;

import javapocalypse.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();
}
