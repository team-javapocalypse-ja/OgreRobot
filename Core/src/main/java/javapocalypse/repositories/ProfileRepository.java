package javapocalypse.repositories;

import javapocalypse.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

    List<Profile> findAll();
}
