package org.shopProject;

import java.util.Map;

public final class Order {
    private final int orderID;
    private static int nextOrderId = 1;
    private final String orderNumber;
    private double orderSum;
    private final String clientName;
    private final String clientSurname;
    private final String clientAddress;
    private final OrderStatus orderStatus;
    private final Map<Product, Integer> products;

    public Order(int orderID, String orderNumber, double orderSum, String clientName, String clientSurname,
                 String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
        this.orderID = nextOrderId++;
        this.orderNumber = orderNumber;
        validateOrderSum(orderSum);
        this.orderSum = orderSum;
        validateClientName(clientName);
        this.clientName = clientName;
        validateClientSurname(clientSurname);
        this.clientSurname = clientSurname;
        validateClientAddress(clientAddress);
        this.clientAddress = clientAddress;
        this.orderStatus = orderStatus;
        validateProducts(products);
        this.products = products;
    }

    private int getOrderID() {
        return orderID;
    }

    private String getOrderNumber() {
        return orderNumber;
    }


    private double getOrderSum() {
        return orderSum;
    }

    private void validateOrderSum(final double orderSum) {
        if (!(orderSum > 0)) {
            throw new IllegalArgumentException("Suma zamówienia powinna być większa od 0.");
        }
    }

    private String getClientName() {
        return clientName;
    }

    private void validateClientName(final String clientName) {
        if (clientName == null || clientName.isBlank() || clientName.length() <= 0 || clientName.length() > 50
                || !clientName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Imię klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    private String getClientSurname() {
        return clientSurname;
    }

    private void validateClientSurname(final String clientSurname) {
        if (clientSurname == null || clientSurname.isBlank() || clientSurname.length() <= 0
                || clientSurname.length() > 50 || !clientSurname.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Nazwisko klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    private String getClientAddress() {
        return clientAddress;
    }

    private void validateClientAddress(final String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0
                || clientAddress.length() > 50) {
            throw new IllegalArgumentException("Adres klienta powinien zawierać od 1 do 50 znaków i nie może być pusty.");
        }
    }

    private OrderStatus getOrderStatus() {
        return orderStatus;
    }

    private Map<Product, Integer> getProducts() {
        return products;
    }

    private void validateProducts(final Map<Product, Integer> products) {
        if (products == null) {
            throw new IllegalArgumentException("Lista produktów nie może być pusta.");
        }
    }
}
