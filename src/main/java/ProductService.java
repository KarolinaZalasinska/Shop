import java.util.HashSet;
import java.util.Set;

public final class ProductService extends Product {
    Set<Product> productSet = new HashSet<Product>();
    public void addProduct(double price, String name, Category category, int quantity) {
        super.productId++;
        this.price = price;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        productSet.add(this);
    }


}
