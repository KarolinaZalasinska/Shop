package model;

import java.util.Map;

public record Order(int orderID, String orderNumber, Customer customer, OrderStatus orderStatus,
					Map<Product, Integer> products) {
	public Order {
		validateProducts(products);
	}


	private void validateProducts(final Map<Product, Integer> products) {
		if (products == null) {
			throw new IllegalArgumentException("Lista produktów nie może być pusta!");
		}
	}

	public void setOrderStatus(final OrderStatus orderStatus) {
	}
}
