package crud.expo.Repository;

import crud.expo.models.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository<Team, Integer> {
}
