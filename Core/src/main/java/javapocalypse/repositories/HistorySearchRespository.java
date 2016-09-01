package javapocalypse.repositories;

import javapocalypse.model.HistorySearch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistorySearchRespository extends CrudRepository<HistorySearch, Integer> {

    List<HistorySearch> findAll();
}
