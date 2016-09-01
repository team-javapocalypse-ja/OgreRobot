package javapocalypse.repositories;

import javapocalypse.model.LibraryCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LibraryCategoryRepository extends CrudRepository<LibraryCategory, Integer> {

    List<LibraryCategory> findAll();
}
