package service;

import model.Order;
import model.OrderStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class OrderService {
    private final List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
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