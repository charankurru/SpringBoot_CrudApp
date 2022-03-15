package crud.expo;

import crud.expo.models.Cart;
import crud.expo.models.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}
//	Cart cart1 = new Cart("sweets");
//	Item chocolate = new Item(1,"choco",12,cart1);
//	Item chocolate2 = new Item(1,"choco1",14,cart1);
//	List<Item> sweets = Arrays.asList(chocolate,chocolate2);
//	cart1.setItems(sweets);
}
