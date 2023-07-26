package service;

import model.Customer;
import model.Order;
import model.OrderStatus;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderService {
	private final List<Order> orders = new ArrayList<>();
	private int nextOrderId;

	private int generateOrderId() {
		return nextOrderId++;
	}

	private String generateOrderNumber() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public Order createAndAddOrder(final Customer customer, final OrderStatus orderStatus, final Map<Product, Integer> products) {
		final Order addNewOrder = new Order(generateOrderId(), generateOrderNumber(), customer, orderStatus, products);
		orders.add(addNewOrder);
		return addNewOrder;
	}

	public boolean removeOrderByNumber(final String orderNumberToRemove) {
		return orders.removeIf(order -> order.orderNumber().equals(orderNumberToRemove));
	}

	public List<Order> getAllOrders() {
		return new ArrayList<>(orders);
	}

	public Order getLastOrder() {
		return orders.stream()
				.reduce((first, second) -> second)
				.orElse(null);
	}

	public Order findOrder(final String orderNumber) {
		return orders.stream()
				.filter(o -> o.orderNumber().equals(orderNumber))
				.findFirst()
				.orElse(null);
	}

	public boolean changeOrderStatus(final String orderNumber, final OrderStatus newStatus) {
		final Order order = findOrder(orderNumber);
		if (order != null) {
			order.setOrderStatus(newStatus);
			System.out.println("Zmieniono status zamówienia o numerze " + orderNumber + " na: " + newStatus);
			return true;
		}
		System.out.println("Nie zmieniono statusu dla zamówienia o numerze: " + orderNumber
				+ ". Podany numer zamówienia nie istnieje, bądź jest nieprawidłowy.");
		return false;
	}
}
