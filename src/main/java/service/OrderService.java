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

    public Order createOrder(String clientName, String clientSurname,
                             String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
        return new Order(generateOrderId(), generateOrderNumber(), clientName, clientSurname, clientAddress,
                orderStatus, products);
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Dodano nowe zamówienie o numerze: " + order.orderNumber() + " i ID: " + order.orderID());
    }

    public void removeOrderByNumber(final String orderNumber) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.orderNumber().equals(orderNumber)) {
                iterator.remove();
                System.out.println("Usunięto zamówienie o numerze: " + orderNumber);
                return;
            }
        }
        System.out.println("Nie znaleziono zamówienia o numerze: " + orderNumber);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order getLastOrder() {
        return orders.stream()
                .reduce((first, second) -> second)
                .orElse(null);
    }

    public void showOrderStatus(final String orderNumber) {
        Order order = orders.stream()
                .filter(o -> o.orderNumber().equals(orderNumber))
                .findFirst()
                .orElse(null);

        if (order != null) {
            System.out.println("Status zamówienia o numerze " + orderNumber + " to: " + order.orderStatus());
        } else {
            System.out.println("Nie znaleziono statusu dla zamówienia o numerze: " + orderNumber);
        }
    }


    public void changeOrderStatus(final String orderNumber, OrderStatus newStatus) {
        Order order = orders.stream()
                .filter(o -> o.orderNumber().equals(orderNumber)).findFirst().orElse(null);
        if (order != null) {
            order.setOrderStatus(newStatus);
            System.out.println("Zmieniono status zamówienia o numerze " + orderNumber + " na: " + newStatus);
        } else {
            System.out.println("Nie zmieniono statusu dla zamówienia o numerze: " + orderNumber
                    + ". Podany numer zamówienia nie istnieje, bądź jest nieprawidłowy.");
        }
    }
}