package crud.expo.Repository;

import crud.expo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepo extends CrudRepository<Product, Integer> {

}
