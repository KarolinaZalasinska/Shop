package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService extends Product {
    private List<Product> products;
    private int nextProductId = 1;
    public ProductService(int productId, double price, String name, Category category, int quantity, List<Product> products) {
        super(productId, price, name, category, quantity);
        this.products = products;
    }

    public void addProduct(double price, String name, Category category, int quantity) {
        Product product = new Product(nextProductId, price, name, category, quantity);
        products.add(product);
        nextProductId++;
    }

    public void removeProduct(int productId) {
        products = products.stream()
                .filter(product -> product.getProductId() != productId)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
}
