package crud.expo.Repository;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    @Query(value = "Select new crud.expo.dto.CustomerProductResponse(E.firstName, P.productName, P.price) from Employee E JOIN E.products P ")
    public List<CustomerProductResponse> getCustomerWithProducts();
}
