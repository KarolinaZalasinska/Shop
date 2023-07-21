package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public List<Product> createProducts(List<Category> categories) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(generateProductId(), 199.99, "Dress", categories.get(0), 100));
        products.add(new Product(generateProductId(), 149.99, "Heels", categories.get(1), 200));
        products.add(new Product(generateProductId(), 39.99, "Cap", categories.get(2), 70));
        products.add(new Product(generateProductId(), 79.99, "Trousers", categories.get(0), 80));
        products.add(new Product(generateProductId(), 249.99, "Sneakers", categories.get(1), 150));
        products.add(new Product(generateProductId(), 19.99, "Hat", categories.get(2), 110));
        return products;
    }

    private int generateProductId() {
        return generateProductId();
    }

    public static final Product NO_PRODUCT = new Product(-1, 0, "No Product", null, 0);

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products = products.stream()
                .filter(product -> product.productId() != productId)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.productId() == productId)
                .findFirst()
                .orElse(NO_PRODUCT);
    }
}