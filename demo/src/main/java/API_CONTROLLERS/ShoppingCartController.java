package API_CONTROLLERS;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private List<CartItem> cart = new ArrayList<>();

    @PostMapping("/add")
    public String addItem(@RequestBody CartItem item) {
        cart.add(item);
        return "Item added";
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cart;
    }

    @DeleteMapping("/remove/{name}")
    public String removeItem(@PathVariable String name) {
        cart.removeIf(item -> item.getName().equalsIgnoreCase(name));
        return "Item removed";
    }

    @DeleteMapping("/clear")
    public String clearCart() {
        cart.clear();
        return "Cart cleared";
    }

    @GetMapping("/count")
    public int countItems() {
        return cart.size();
    }
}

class CartItem {
    private String name;
    private int quantity;

    public CartItem() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

