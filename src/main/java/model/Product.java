package model;

import java.util.Objects;

public record Product(int productId, double price, String name, Category category, int quantity) {
    public Product {
        validatePrice(price);
        validateName(name);
        validateCategory(category);
        validateQuantity(quantity);
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena produktu musi być większa od 0.");
        }
    }

    private void validateName(String name) {
        if (name == null || !name.matches("^[a-zA-Z]{1,50}$")) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa produktu.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Kategoria produktu nie może być pusta.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Ilość produktu musi być większa od 0.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price, name, category, quantity);
    }
}