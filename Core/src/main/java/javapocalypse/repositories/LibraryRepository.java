package javapocalypse.repositories;

import javapocalypse.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LibraryRepository extends CrudRepository<Library, Integer> {

    List<Library> findAll();
}
