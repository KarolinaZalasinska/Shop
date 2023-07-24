package model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record Order(int orderID, String orderNumber, double orderSum, String clientName, String clientSurname,
                    String clientAddress, OrderStatus orderStatus, Map<Product, Integer> products) {
    public Order {
        validateClientName(clientName);
        validateClientSurname(clientSurname);
        validateOrderSum(orderSum);
        validateClientAddress(clientAddress);
        validateProducts(products);
    }

    private static int nextOrderId = 1;

    public String generateOrderNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private void validateOrderSum(final double orderSum) {
        if (!(0 < orderSum)) {
            throw new IllegalArgumentException("Suma zamówienia powinna być większa od 0.");
        }
    }

    private void validateClientName(final String clientName) {
        if ((clientName == null) || !"^[a-zA-Z]{1,50}$".matches(clientName)) {
            throw new IllegalArgumentException("Imię klienta powinno zawierać od 1 do 50 liter i nie może być puste.");
        }
    }

    private void validateClientSurname(final String clientSurname) {
        if ((clientSurname == null) || !"^[a-zA-Z]{1,50}+$".matches(clientSurname)) {
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

    //public double orderSum(Map<Product, Integer> orderProducts) {}
}