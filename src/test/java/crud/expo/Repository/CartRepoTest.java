package crud.expo.Repository;

import crud.expo.models.Cart;
import crud.expo.models.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CartRepoTest {
    @Autowired CartRepo cartRepo;

    Cart saveTestCartData(){

      Cart cart = new Cart();
      cart.setCartName("TestCart");
      Item item1 = new Item();
      item1.setItemName("testItem1");
      item1.setPrice(50);
      Item item2 = new Item();
      item2.setItemName("testitem2");
      item2.setPrice(100);
      List<Item>items = Arrays.asList(item1,item2);
      cart.setItems(items);
      return cartRepo.save(cart);
    }

    @Test
    void testFindAllDataSuccess(){
        saveTestCartData();
        List<Cart> carts = (List<Cart>) cartRepo.findAll();
        assertEquals(1,carts.size());
    }

    @Test
    void testFindAllDataWithNoData(){
        List<Cart> carts = (List<Cart>) cartRepo.findAll();
        assertEquals(0,carts.size());
    }

}