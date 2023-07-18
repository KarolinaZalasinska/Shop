package org.example;

import java.util.Map;

public class Order {
    private int orderID;
    private String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private OrderStatus orderStatus;
    private Map<Product, Integer> products;

    public Order(int orderID, String orderNumber, double orderSum, String clientName, String clientSurname,
                 String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
        this.orderID = orderID;
        this.orderNumber = orderNumber;
        this.orderSum = orderSum;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void validateOrderSum(double orderSum) {
        if (orderSum > 0) {
            this.orderSum = orderSum;
        } else {
            throw new IllegalArgumentException("Suma zamówienia musi być większa od 0.");
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void validateClientName(String clientName) {
        if (clientName != null && !clientName.isBlank() && clientName.length() > 0 && clientName.length() <= 50 && clientName.matches("^[a-zA-Z]+$")) {
            this.clientName = clientName;
        } else {
            throw new IllegalArgumentException("Imię klienta musi zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void validateClientSurname(String clientSurname) {
        if (clientSurname != null && !clientSurname.isBlank() && clientSurname.length() > 0 && clientSurname.length() <= 50 && clientSurname.matches("^[a-zA-Z]+$")) {
            this.clientSurname = clientSurname;
        } else {
            throw new IllegalArgumentException("Nazwisko klienta musi zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void validateClientAddress(String clientAddress) {
        if (clientAddress != null && !clientAddress.isBlank() && clientAddress.length() > 0 && clientAddress.length() <= 50) {
            this.clientAddress = clientAddress;
        } else {
            throw new IllegalArgumentException("Adres klienta musi zawierać od 1 do 50 znaków i nie może być pusty.");
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void validateProducts(Map<Product, Integer> products) {
        if (products != null) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("Lista produktów nie może być pusta.");
        }
    }
}
