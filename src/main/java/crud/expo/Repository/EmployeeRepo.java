package crud.expo.Repository;

import crud.expo.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, String> {
    // void deleteEById(String name);
    //    void deleteBylastName(String name);
    //    Employee findBylastName(String name);
}
