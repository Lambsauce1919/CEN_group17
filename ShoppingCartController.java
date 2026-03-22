import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private List<Map<String, Object>> cart = new ArrayList<>();

    // ✅ Add item
    @PostMapping("/add")
    public String addItem(@RequestBody Map<String, Object> item) {
        cart.add(item);
        return "Book added";
    }

    // ✅ View cart
    @GetMapping("/{userId}")
    public List<Map<String, Object>> getCart(@PathVariable String userId) {
        List<Map<String, Object>> userCart = new ArrayList<>();
        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(userId)) {
                userCart.add(c);
            }
        }
        return userCart;
    }

    // ✅ Remove item
    @DeleteMapping("/{userId}/{bookId}")
    public String removeItem(@PathVariable String userId, @PathVariable String bookId) {
        cart.removeIf(c -> c.get("userId").equals(userId) && c.get("bookId").equals(bookId));
        return "Removed";
    }

    // ✅ Update quantity
    @PutMapping("/update")
    public String updateQuantity(@RequestBody Map<String, Object> data) {
        String userId = data.get("userId").toString();
        String bookId = data.get("bookId").toString();
        int quantity = Integer.parseInt(data.get("quantity").toString());

        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(userId) && c.get("bookId").equals(bookId)) {
                c.put("quantity", quantity);
                return "Quantity updated";
            }
        }
        return "Item not found";
    }

    // ✅ Count items
    @GetMapping("/count/{userId}")
    public int countItems(@PathVariable String userId) {
        int count = 0;
        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(userId)) {
                count++;
            }
        }
        return count;
    }

    // ✅ Clear cart
    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable String userId) {
        cart.removeIf(c -> c.get("userId").equals(userId));
        return "Cart cleared";
    }
}
