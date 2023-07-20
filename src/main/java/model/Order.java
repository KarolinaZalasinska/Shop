package model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record Order(int orderID, String orderNumber, double orderSum, String clientName, String clientSurname,
                    String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {

    private static int nextOrderId = 1;

    public Order(String orderNumber, double orderSum, String clientName, String clientSurname,
                 String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
        this(nextOrderId++, generateOrderNumber(), orderSum, clientName, clientSurname, clientAddress, orderStatus, products);
    }
    private static String generateOrderNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private void validateOrderSum(final double orderSum) {
        if (!(orderSum > 0)) {
            throw new IllegalArgumentException("Suma zamówienia powinna być większa od 0.");
        }
    }

    private void validateClientName(final String clientName) {
        if (clientName == null || !clientName.matches("^[a-zA-Z]{1,50}+$")) { //isBlank ???????/???????
            throw new IllegalArgumentException("Imię klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    private void validateClientSurname(final String clientSurname) {
        if (clientSurname == null || !clientSurname.matches("^[a-zA-Z]{1,50}+$")) { //isBlank???????
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

    public void setOrderStatus(OrderStatus orderStatus) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Double.compare(order.orderSum, orderSum) == 0
                && Objects.equals(orderNumber, order.orderNumber) && Objects.equals(clientName, order.clientName)
                && Objects.equals(clientSurname, order.clientSurname)
                && Objects.equals(clientAddress, order.clientAddress)
                && orderStatus == order.orderStatus
                && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderNumber, orderSum, clientName, clientSurname,
                clientAddress, orderStatus, products);
    }
}