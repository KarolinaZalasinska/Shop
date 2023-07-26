package model;

import java.util.regex.Pattern;

public record Category(String name, int categoryID) {

	public Category {
		validateName(name);
	}

	private void validateName(final String name) {
		if (name == null || !Pattern.matches("^[a-zA-Z]{1,50}+$", name)) {
			throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
		}
	}
}

//    lub boolean
//
//    public boolean validateName(String name) {
//        return name != null && Pattern.matches("^[a-zA-Z]{1,50}+$", name);
//    }
