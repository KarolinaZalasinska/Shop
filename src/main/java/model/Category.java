package model;

import java.util.Objects;
import java.util.regex.Pattern;

public record Category(String name, int categoryID) {
    private static int nextCategoryID = 1;

    public Category(String name, int categoryID) {
        this.name = name;
        this.categoryID =nextCategoryID++;
        validateCategoryName(name);
    }

    private void validateCategoryName(String name) {
        if (name == null || !Pattern.matches("^[a-zA-Z]{1,50}+$", name)) {
            throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryID == category.categoryID && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, categoryID);
    }
}