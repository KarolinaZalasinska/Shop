package org.shopProject;
import java.util.regex.Pattern;

public final class Category {
    private final int categoryID;
    private final String name;
    private static int nextCategoryId = 1;

    private Category(String name) {
        this.categoryID = nextCategoryId++;
        validateCategoryName(name);
        this.name = name;
    }

    private int getCategoryID() {
        return categoryID;
    }

    private String getName() {
        return name;
    }

    private void validateCategoryName(final String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() > 50 || !Pattern.matches("^[a-zA-Z]+$", name)) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
        }
    }
}