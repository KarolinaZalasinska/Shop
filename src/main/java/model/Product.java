package model;

public record Product(int productId, double price, String name, Category category) {
	public Product {
		validatePrice(price);
		validateName(name);
		validateCategory(category);
	}

	private void validatePrice(final double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Cena produktu musi być większa od 0.");
		}
	}

	private void validateName(final String name) {
		if (name == null || !name.matches("^[a-zA-Z]{1,50}$")) {
			throw new IllegalArgumentException("Nieprawidłowa nazwa produktu.");
		}
	}


	private void validateCategory(final Category category) {
		if (category == null) {
			throw new IllegalArgumentException("Kategoria produktu nie może być pusta.");
		}
	}
}
