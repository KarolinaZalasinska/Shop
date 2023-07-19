package org.example;

public class Product {
    private final int productId;
    private final double price;
    private final String name;
    private final Category category;
    private final int quantity;

    public Product(int productId, double price, String name, Category category, int quantity) {
        this.productId = productId;
        this.price = price;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean validatePrice(double price) {
        return price > 0;
    }

    public boolean validateName(String name) {
        return name != null &&
                !name.isBlank() &&
                name.length() > 0 &&
                name.length() < 50 &&
                name.chars().allMatch(Character::isLetter);
    }

    public boolean validateCategory(Category category) {
        return category != null;
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
