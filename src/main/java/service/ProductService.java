package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private int lastUsedProductId;

    private int generateProductId() {
        return lastUsedProductId++;
    }

    public Product createAndAddProduct(double price, String name, Category category) {
        Product newProduct = new Product(generateProductId(), price, name, category);
        products.add(newProduct);
        return newProduct;
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(product -> product.productId() == productId);
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
}
