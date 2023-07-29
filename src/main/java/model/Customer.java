package model;

public record Customer(String firstName, String lastName, String address) {
	public Customer {
		validateFirstName(firstName);
		validateLastName(lastName);
		validateAddress(address);
	}

	private void validateFirstName(final String firstName) {
		if (firstName == null || !firstName.matches("^[a-zA-Z]{1,50}$")) {
			throw new IllegalArgumentException("Imię klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
		}
	}

	private void validateLastName(final String lastName) {
		if (lastName == null || !lastName.matches("^[a-zA-Z]{1,50}$")) {
			throw new IllegalArgumentException("Nazwisko klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
		}
	}

	private void validateAddress(final String address) {
		if (address == null || address.isEmpty() || address.length() > 50) {
			throw new IllegalArgumentException("Adres klienta powinien zawierać od 1 do 50 znaków i nie może być pusty.");
		}
	}
}
