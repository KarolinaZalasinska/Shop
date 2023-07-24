package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public final class CategoryService {
    private List<Category> categories = new ArrayList<>();
    private int nextCategoryID;

    private int generateCategoryId() {
        return nextCategoryID++;
    }

    public Category createAndAddCategory(String name) {
        Category newCategory = new Category(name, generateCategoryId());
        categories.add(newCategory);
        return newCategory;
    }

    public boolean removeCategory(int categoryIdToRemove) {
        return categories.removeIf(category -> category.categoryID() == categoryIdToRemove);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    public Category getCategoryByIdOrName(int categoryId, String categoryName) {
        return categories.stream()
                .filter(c -> c.categoryID() == categoryId || c.name().equals(categoryName))
                .findFirst()
                .orElse(null);
    }
}
