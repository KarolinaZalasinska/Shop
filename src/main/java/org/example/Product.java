package org.example;

public sealed class Product permits ProductService {
    protected int productId = 1;
    protected double price;
    protected String name;
    protected Category category;
    protected int quantity;

    protected int getProductId() {
        return productId;
    }

    protected double getPrice() {
        return price;
    }

    protected String getName() {
        return name;
    }

    protected Category getCategory() {
        return category;
    }

    protected int getQuantity() {
        return quantity;
    }

    protected boolean validatePrice(double price) {
        return price > 0;
    }

    protected boolean validateName(String name) {
        return name != null &&
                !name.isBlank() && name.length() > 0 &&
                name.length() < 50 &&
                name.chars().allMatch(Character::isLetter);
    }

    protected boolean validateCategory(Category category) {
        return category != null;
    }

    protected boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
