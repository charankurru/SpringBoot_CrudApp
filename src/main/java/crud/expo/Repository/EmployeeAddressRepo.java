package crud.expo.Repository;

import crud.expo.models.EmployeeAddress;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeAddressRepo extends CrudRepository<EmployeeAddress,Integer> {
}
