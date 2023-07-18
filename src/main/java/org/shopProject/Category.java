package org.shopProject;

import java.util.regex.Pattern;

public class Category {
    private int categoryID;
    private String name;

    public Category(int categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
       return name;
    }


    public boolean validateCategoryName(String name) {
        return name != null && !name.isBlank() && name.length() > 0 && name.length() <= 50 && Pattern.matches("^[a-zA-Z]+$", name);
    }
}

