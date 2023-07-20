package org.example;

import java.util.Objects;

public class Product {
    private final int productId;
    private final double price;
    private final String name;
    private final Category category;
    private final int quantity;

    public Product(int productId, double price, String name, Category category, int quantity) {
        if (validatePrice(price) &&
                validateName(name) &&
                validateCategory(category) &&
                validateQuantity(quantity)) {
            this.productId = productId;
            this.price = price;
            this.name = name;
            this.category = category;
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa cena, nazwa, kategoria lub ilość");
        }
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

    private boolean validatePrice(double price) {
        return price > 0;
    }

    private boolean validateName(String name) {
        return name != null &&
                !name.isBlank() &&
                name.length() > 0 &&
                name.length() < 50 &&
                name.chars().allMatch(Character::isLetter);
    }

    private boolean validateCategory(Category category) {
        return category != null;
    }

    private boolean validateQuantity(int quantity) {
        return quantity > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getProductId() == product.getProductId() && Double.compare(product.getPrice(), getPrice()) == 0 && getQuantity() == product.getQuantity() && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getPrice(), getName(), getCategory(), getQuantity());
    }
}
