package org.example;

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

    public void showAllProducts() {
        System.out.println(productSet);
    }

    public void showProduct(Product product) {
        System.out.println(product.getProductId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println(product.getCategory());
    }
}
