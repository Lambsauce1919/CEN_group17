@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private List<Map<String, Object>> cart = new ArrayList<>();

    // Add item (handles duplicate → updates quantity)
    @PostMapping("/add")
    public String addItem(@RequestBody Map<String, Object> item) {
        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(item.get("userId")) &&
                c.get("itemId").equals(item.get("itemId"))) {

                int qty = (int) c.get("quantity");
                c.put("quantity", qty + (int) item.get("quantity"));
                return "Item quantity updated";
            }
        }
        cart.add(item);
        return "Item added";
    }

    // View cart
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

    // Update quantity
    @PutMapping("/{userId}/{itemId}")
    public String updateItem(@PathVariable String userId,
                             @PathVariable String itemId,
                             @RequestBody Map<String, Object> body) {

        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(userId) &&
                c.get("itemId").equals(itemId)) {

                c.put("quantity", body.get("quantity"));
                return "Item updated";
            }
        }
        return "Item not found";
    }

    // Remove item
    @DeleteMapping("/{userId}/{itemId}")
    public String removeItem(@PathVariable String userId,
                             @PathVariable String itemId) {

        cart.removeIf(c ->
            c.get("userId").equals(userId) &&
            c.get("itemId").equals(itemId)
        );
        return "Item removed";
    }

    // Get total price
    @GetMapping("/total/{userId}")
    public double getTotal(@PathVariable String userId) {
        double total = 0;

        for (Map<String, Object> c : cart) {
            if (c.get("userId").equals(userId)) {
                int qty = (int) c.get("quantity");
                double price = (double) c.get("price");
                total += qty * price;
            }
        }
        return total;
    }
}
