package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private int lastUsedProductId;

    private int generateProductId() {
        return lastUsedProductId++;
    }

    public Product createProduct(double price, String name, Category category) {
        return new Product(generateProductId(), price, name, category);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.productId() == productId);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.productId() == productId)
                .findFirst()
                .orElse(null);
    }
//    public int getLastUsedProductId() {
//        return lastUsedProductId;
//    }
}