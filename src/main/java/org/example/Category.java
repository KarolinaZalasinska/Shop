package org.example;

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


    public void validateName(String name) {
        if (name != null && !name.isBlank() && name.length() > 0 && name.length() <= 50 && name.matches("^[a-zA-Z]+$")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Nazwa kategorii musi zawierać od 1 do 50 liter i nie może być pusta.");
        }
    }
}

