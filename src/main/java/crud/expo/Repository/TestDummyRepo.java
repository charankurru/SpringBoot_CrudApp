package crud.expo.Repository;

import crud.expo.models.TestDummy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDummyRepo extends CrudRepository<TestDummy, Integer> {
}
