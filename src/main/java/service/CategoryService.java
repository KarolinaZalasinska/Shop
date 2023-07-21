package service;

import model.Category;
import java.util.ArrayList;
import java.util.List;

public final class CategoryService {
    public static List<Category> categories;
    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        Category newCategory = new Category(name, categories.size() + 1);
        categories.add(newCategory);
    }
    public List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Clothes", generateCategoryId()));
        categories.add(new Category("Shoes", generateCategoryId()));
        categories.add(new Category("Accessories", generateCategoryId()));
        return categories;
    }

    private int generateCategoryId() {
        return generateCategoryId();
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