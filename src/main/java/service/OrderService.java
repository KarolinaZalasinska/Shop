package service;

import model.Order;
import model.OrderStatus;
import model.Product;

import java.util.*;

public final class OrderService {
    private final List<Order> orders;
    Map<Product, Integer> productsMap = new HashMap<>();
//productsMap.put(newProduct(1,100.0,"Product 1",category1, 10), 5);
//productsMap.put(new Product(2,200.0,"Product 2",category2, 20), 3);

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    String orderNumber1 = UUID.randomUUID().toString().substring(0, 8);
    String orderNumber2 = UUID.randomUUID().toString().substring(0, 8);
    String orderNumber3 = UUID.randomUUID().toString().substring(0, 8);

    Order order1 = new Order(1, orderNumber1, 579.99, "Anna", "Nowak",
            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);
    Order order2 = new Order(2, orderNumber2, 389.99, "Jan", "Kowalski",
            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);
    Order order3 = new Order(3, orderNumber3, 89.99, "Hanna", "Malinowska",
            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);


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