package crud.expo.Repository;

import crud.expo.models.StudentProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepo extends CrudRepository<StudentProfile,Integer> {
}
