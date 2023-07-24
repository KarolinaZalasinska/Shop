package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public final class CategoryService {
    private List<Category> categories = new ArrayList<>();
    private int nextCategoryID = 1;

    private int generateCategoryId() {
        return nextCategoryID++;
    }

    public Category createCategory(String name) {
        return new Category(name, generateCategoryId());
    }

    public void addCategory(String name) {
        Category newCategory = new Category(name, categories.size() + 1);
        categories.add(newCategory);
    }

    public void removeCategory(int categoryID) {
        categories.removeIf(c -> c.categoryID() == categoryID);
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