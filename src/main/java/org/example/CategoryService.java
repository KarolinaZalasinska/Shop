package org.example;

import java.util.List;

public class CategoryService extends Category{
    private List<Category>categories;
    public CategoryService(int categoryID, String name) {
        super(categoryID, name);
    }

}
