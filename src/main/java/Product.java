public class Product {
    private int productId;
    private double price;
    private String name;
    private int quantity;

    boolean validatePrice(double price) {
        return price > 0;
    }

    boolean validateName(String name) {
        return name != null &&
                !name.isBlank() && name.length() > 0 &&
                name.length() < 50 &&
                name.chars().allMatch(Character::isLetter);
    }

    boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
