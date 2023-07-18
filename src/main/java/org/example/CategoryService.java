package org.example;

import java.util.List;
import java.util.stream.Collectors;

public final class CategoryService extends Category {
    private List<Category> categories;
    private int nextCategoryId = 1;

    public CategoryService(int categoryID, String name, List<Category> categories) {
        super(categoryID, name);
        this.categories = categories;
    }

    public void addCategory(String categoryName) {
        if (validateCategoryName(categoryName)) {
            Category category = new Category(nextCategoryId, categoryName);
            categories.add(category);
            nextCategoryId++;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
        }
    }

    public void removeCategory(int categoryID) {
        categories = categories.stream()
                .filter(category -> category.getCategoryID() != categoryID)
                .collect(Collectors.toList());
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryByID(int categoryID) {
        return categories.stream()
                .filter(category -> category.getCategoryID() == categoryID)
                .findFirst()
                .orElse(null);
    }
}

