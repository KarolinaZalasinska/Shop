package model;

public record Category(String name, int categoryID) {

	public Category {
		validateName(name);
	}

	private void validateName(final String name) {
		if (name == null || !name.matches("^[a-zA-Z]{1,50}$")) {
			throw new IllegalArgumentException("Nieprawidłowa nazwa kategorii.");
		}
	}
}
