package javapocalypse.core.model.repositories;

import javapocalypse.core.model.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

}
