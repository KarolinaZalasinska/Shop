public sealed class Product permits ProductService {
    private int productId;
    private double price;
    private String name;
    private Category category;
    private int quantity;

    public Product(int productId, double price, String name, Category category, int quantity) {
        this.productId = productId;
        this.price = price;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected boolean validatePrice(double price) {
        return price > 0;
    }

    protected boolean validateName(String name) {
        return name != null &&
                !name.isBlank() && name.length() > 0 &&
                name.length() < 50 &&
                name.chars().allMatch(Character::isLetter);
    }

    protected boolean validateCategory(Category category) {
        return category != null;
    }

    protected boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
