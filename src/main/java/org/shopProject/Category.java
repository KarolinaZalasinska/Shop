package org.shopProject;
import java.util.regex.Pattern;

public class Category {
    private final int categoryID;
    private final String name;
    private static int nextCategoryId = 1;

    public Category(String name) {
        this.categoryID = nextCategoryId++;
        this.name = validateAndSetCategoryName(name);
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    private final String validateAndSetCategoryName(String name) {
        if (name != null && !name.isBlank() && name.length() > 0 && name.length() <= 50 && Pattern.matches("^[a-zA-Z]+$", name)) {
            return name;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
        }
    }
}