package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public final class CategoryService {
    private List<Category> categories;
    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        Category newCategory = new Category(name, categories.size() + 1);
        categories.add(newCategory);
    }

    public void removeCategory(int categoryID) {
        categories.removeIf(category -> category.categoryID() == categoryID);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    public Category getCategoryByID(int categoryID) {
        return categories.stream()
                .filter(category -> categoryID == category.categoryID())
                .findFirst()
                .orElse(null);
    }
}