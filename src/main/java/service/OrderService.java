package service;

import model.Order;
import model.OrderStatus;
import model.Product;

import java.util.UUID;

import java.util.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private Map<Product, Integer> productsMap = new HashMap<>();
    private int nextOrderId = 1;

    private int generateOrderId() {
        return nextOrderId++;
    }

    private String generateOrderNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public Order createAndAddOrder(String clientName, String clientSurname,
                             String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
        Order addNewOrder = new Order(generateOrderId(), generateOrderNumber(), clientName, clientSurname, clientAddress,
                orderStatus, products);
        orders.add(addNewOrder);
        return addNewOrder;
    }

    public boolean removeOrderByNumber(String orderNumberToRemove) {
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
}
