package generate;

import model.Category;
import model.Order;
import model.OrderStatus;
import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenerateCategories {

    public List<Order> orders = new ArrayList<>();

    public List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Clothing", generateCategoryId()));
        categories.add(new Category("Footwear", generateCategoryId()));
        categories.add(new Category("Accessories", generateCategoryId()));
        return categories;
    }

    public List<Product> createProducts(List<Category> categories) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(generateProductId(), 199.99, "Dress", categories.get(0)));
        products.add(new Product(generateProductId(), 149.99, "Heels", categories.get(1)));
        products.add(new Product(generateProductId(), 39.99, "Cap", categories.get(2)));
        products.add(new Product(generateProductId(), 79.99, "Trousers", categories.get(0)));
        products.add(new Product(generateProductId(), 249.99, "Sneakers", categories.get(1)));
        products.add(new Product(generateProductId(), 19.99, "Hat", categories.get(2)));
        products.add(new Product(generateProductId(), 79.99, "Earrings", categories.get(2)));
        return products;
    }

    public void changeOrderStatus(final String orderNumber, OrderStatus newStatus) {
        Order order = orders.stream()
                .filter(o -> o.orderNumber().equals(orderNumber)).findFirst().orElse(null);
        if (order != null) {
            order.setOrderStatus(newStatus);
            System.out.println("Zmieniono status zamówienia o numerze " + orderNumber + " na: " + newStatus);
        } else {
            System.out.println("Nie zmieniono statusu dla zamówienia o numerze: " + orderNumber
                    + ". Podany numer zamówienia nie istnieje, bądź jest nieprawidłowy.");
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    private int generateCategoryId() {
        return UUID.randomUUID().hashCode();
    }

    private int generateProductId() {
        return UUID.randomUUID().hashCode();
    }
}
