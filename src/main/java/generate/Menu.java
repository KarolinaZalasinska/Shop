//package generate;
//
//import model.Category;
//import model.Order;
//import model.OrderStatus;
//import model.Product;
//import service.CategoryService;
//import service.ProductService;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import static java.util.Collections.*;
//
//public class Menu {
//    public static void main(String[] args) {
//        CategoryService categoryService = new CategoryService();
//        categoryService.addCategory("Clothes");
//        categoryService.addCategory("Shoes");
//        categoryService.addCategory("Accessories");
//
//        List<Category> allCategories = categoryService.getAllCategories();
//        System.out.println("Wszystkie kategorie:");
//        for (Category category : allCategories) {
//            System.out.println(category.name());
//        }
//
//        int categoryIDToRemove = 2;
//        categoryService.removeCategory(categoryIDToRemove);
//        System.out.println("Usunięto kategorię o ID: " + categoryIDToRemove);
//
//        ProductService productService = new ProductService();
//        List<Product> products;
//        products = unmodifiableList(productService.createProducts(allCategories));
//
//        Product newProduct = new Product(7, 69.99, "Boots", allCategories.get(1), 330);
//        productService.addProduct(newProduct);
//
//        List<Product> allProducts = productService.getAllProducts();
//        System.out.println("\nWszystkie produkty:");
//        for (Product product : allProducts) {
//            System.out.println(product.name());
//        }
//
//        int productIdToFind = 1;
//        Product productById = productService.getProductById(productIdToFind);
//        if (productById != ProductService.NO_PRODUCT) {
//            System.out.println("Wybrany produkt: " + productById);
//        } else {
//            System.out.println("Produkt o podanym ID nie istnieje.");
//        }
//        System.out.println("Wybrany produkt:");
//
//        String orderNumber1 = UUID.randomUUID().toString().substring(0, 8);
//        String orderNumber2 = UUID.randomUUID().toString().substring(0, 8);
//        String orderNumber3 = UUID.randomUUID().toString().substring(0, 8);
//
//        Product product1 = new Product(1, 199.99, "Dress", allCategories.get(0), 100);
//        Product product2 = new Product(2, 149.99, "Heels", allCategories.get(1), 200);
//        Product product3 = new Product(3, 39.99, "Cap", allCategories.get(2), 70);
//
//        Map<Product, Integer> productsMap1 = new HashMap<>();
//        productsMap1.put(product1, 2);
//        productsMap1.put(product2, 1);
//
//        Map<Product, Integer> productsMap2 = new HashMap<>();
//        productsMap2.put(product1, 1);
//        productsMap2.put(product3, 3);
//
//        Map<Product, Integer> productsMap3 = new HashMap<>();
//        productsMap3.put(product2, 5);
//        productsMap3.put(product3, 2);
//
//        Order order1 = new Order(1, orderNumber1, 579.99, "Anna", "Nowak",
//                "Kryształowa 7", OrderStatus.SHIPPED, productsMap1);
//        Order order2 = new Order(2, orderNumber2, 389.99, "Jan", "Kowalski",
//                "Kryształowa 7", OrderStatus.SHIPPED, productsMap2);
//        Order order3 = new Order(3, orderNumber3, 89.99, "Hanna", "Malinowska",
//                "Kryształowa 7", OrderStatus.SHIPPED, productsMap3);
//
//        System.out.println(order1);
//        System.out.println(order2);
//        System.out.println(order3);
//    }
//}

                   //POPRAWIONE !!!!!!!!

//public List<Product> createProducts(List<Category> categories) {
//        List<Product> products = new ArrayList<>();
//
//        products.add(new Product(generateProductId(), 199.99, "Dress", categories.get(0)));
//        products.add(new Product(generateProductId(), 149.99, "Heels", categories.get(1)));
//        products.add(new Product(generateProductId(), 39.99, "Cap", categories.get(2)));
//        products.add(new Product(generateProductId(), 79.99, "Trousers", categories.get(0)));
//        products.add(new Product(generateProductId(), 249.99, "Sneakers", categories.get(1)));
//        products.add(new Product(generateProductId(), 19.99, "Hat", categories.get(2)));
//        return products;
//        }

//public List<Category> createCategories() {
//        List<Category> categories = new ArrayList<>();

//        categories.add(new Category("Clothes", generateCategoryId()));
//        categories.add(new Category("Shoes", generateCategoryId()));
//        categories.add(new Category("Accessories", generateCategoryId()));
//        return categories;
//        }

//    Order order1 = new Order(1, orderNumber1, 579.99, "Anna", "Nowak",
//            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);
//    Order order2 = new Order(2, orderNumber2, 389.99, "Jan", "Kowalski",
//            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);
//    Order order3 = new Order(3, orderNumber3, 89.99, "Hanna", "Malinowska",
//            "Kryształowa 7", OrderStatus.SHIPPED, productsMap);
