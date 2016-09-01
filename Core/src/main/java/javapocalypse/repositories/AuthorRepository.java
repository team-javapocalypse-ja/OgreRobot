package javapocalypse.repositories;

import javapocalypse.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findAll();

}
