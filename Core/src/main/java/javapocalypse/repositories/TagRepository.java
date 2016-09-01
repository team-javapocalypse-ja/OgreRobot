package javapocalypse.repositories;

import javapocalypse.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagRepository extends CrudRepository<Tag, Integer>{

    List<Tag> findAll();
}
