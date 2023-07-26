package model;

import java.util.Map;

public record Order(int orderID, String orderNumber, String clientName, String clientSurname,
					String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
	public Order {
		validateClientName(clientName);
		validateClientSurname(clientSurname);
		validateClientAddress(clientAddress);
		validateProducts(products);
	}

	private void validateClientName(final String clientName) {
		if (clientName == null || !"^[a-zA-Z]{1,50}$".matches(clientName)) {
			throw new IllegalArgumentException("Imię klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
		}
	}

	private void validateClientSurname(final String clientSurname) {
		if (clientSurname == null || !"^[a-zA-Z]{1,50}+$".matches(clientSurname)) {
			throw new IllegalArgumentException("Nazwisko klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
		}
	}

	private void validateClientAddress(final String clientAddress) {
		if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0
				|| clientAddress.length() > 50) {
			throw new IllegalArgumentException("Adres klienta powinien zawierać od 1 do 50 znaków i nie może być pusty.");
		}
	}

	private void validateProducts(final Map<Product, Integer> products) {
		if (products == null) {
			throw new IllegalArgumentException("Lista produktów nie może być pusta!");
		}
	}

	public void setOrderStatus(final OrderStatus orderStatus) {
	}
}
