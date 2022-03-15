package crud.expo.controllers;

import crud.expo.models.Cart;
import crud.expo.models.Item;
import crud.expo.services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;


    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody Item item){
        System.out.println(item.getItemId());
        this.shoppingService.addItem(item);
        return new ResponseEntity<>("Item Added Successfully !!", HttpStatus.OK);
    }

    @PostMapping("/addCartWithItems")
    public ResponseEntity<String> addItem(@RequestBody Cart cart){
        this.shoppingService.addCart(cart);
        return new ResponseEntity<>("Cart Added Successfully !!", HttpStatus.OK);
    }

    @GetMapping("/getShoppingItems")
    public ResponseEntity<List<Cart>>getShoppingItems(){
        return new ResponseEntity<>(this.shoppingService.getCartItems(),HttpStatus.OK);
    }

    @GetMapping("/getItems")
    public ResponseEntity<List<Item>>getItems(){
        return new ResponseEntity<>(this.shoppingService.getItems(),HttpStatus.OK);
    }


}
