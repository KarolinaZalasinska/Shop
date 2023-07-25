package model;

import java.util.Objects;

public record Product(int productId, double price, String name, Category category) {
    public Product {
        validatePrice(price);
        validateName(name);
        validateCategory(category);
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena produktu musi być większa od 0.");
        }
    }

//    private boolean validatePrice(double price) {
//        return price > 0;
//    }

    private void validateName(String name) {
        if (name == null || !name.matches("^[a-zA-Z]{1,50}$")) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa produktu.");
        }
    }

//    private boolean validateName(String name) {
//        return name != null && name.matches("^[a-zA-Z]{1,50}$");
//    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Kategoria produktu nie może być pusta.");
        }
    }

//    private boolean validateCategory(Category category){
//        return category != null;
//    }
}
