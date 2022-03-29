package crud.expo.services;

import crud.expo.Repository.CartRepo;
import crud.expo.Repository.ItemRepo;
import crud.expo.models.Cart;
import crud.expo.models.Item;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShoppingService {
    private final CartRepo cartRepo;
    private final ItemRepo itemRepo;

    public void addItem(Item item) {
        itemRepo.save(item);
    }

    public void addCart(Cart cart) {
        cartRepo.save(cart);
    }


    public List<Cart> getCartItems() {
        return (List<Cart>) cartRepo.findAll();
    }

    public List<Item> getItems() {
        return (List<Item>) itemRepo.findAll();
    }
}
