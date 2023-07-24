package model;

import java.util.regex.Pattern;

public record Category(String name, int categoryID) {
    //private static int nextCategoryID = 1; // Jak rozwiązać sprawę autoinkrementacji ?! Czy pole może być w CS ??

    public Category {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || !Pattern.matches("^[a-zA-Z]{1,50}+$", name)) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
        }
    }
}