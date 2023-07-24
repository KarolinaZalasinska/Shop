package main;

import model.OrderStatus;
import service.ProductService;
import service.CategoryService;
import service.OrderService;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    private final CategoryService categoryService = new CategoryService();
    private final OrderService orderService = new OrderService();

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("[1] Zamówiena");
            System.out.println("[2] Kategorie produktów");
            System.out.println("[3] Produkty");
            System.out.println("[4] Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showOrderSubMenu();
                case 2 -> showCategorySubMenu();
                case 3 -> showProductSubMenu();
                case 4 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }

    public void showOrderSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista zamówień");
            System.out.println("[2,OrderNumber] Konkretne zamówienie");
            System.out.println("[3,clientName,clientSurname,clientAddress,orderStatus,products] Dodaj zamówienie");
            System.out.println("[4,OrderNumber] Usuń zamówienie");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> orderService.getAllOrders();
                case 2 -> orderService.findOrder(words[1]);
                case 3 -> {
//                    orderService.createAndAddOrder(words[1], words[2], words[3],
//                            OrderStatus.valueOf(words[4]), words[5]);
                }
                case 4 -> orderService.removeOrderByNumber(words[1]);
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }

    public void showCategorySubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista kategorii");
            System.out.println("[2,categoryID,categoryName] Konkretna kategoria");
            System.out.println("[3,name] Dodaj kategorie");
            System.out.println("[4,categoryID] Usuń kategorie");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> categoryService.getAllCategories();
                case 2 -> categoryService.getCategoryByIdOrName(Integer.parseInt(words[1]),words[2]);
                case 3 -> categoryService.createAndAddCategory(words[1]);
                case 4 -> categoryService.removeCategory(Integer.parseInt(words[1]));
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista produktów");
            System.out.println("[2,productId] Konkretny produkt");
            System.out.println("[3,price,name,category] Dodaj produkt");
            System.out.println("[4,productId] Usuń produkt ");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> productService.getAllProducts();
                case 2 -> productService.getProductById(Integer.parseInt(words[1]));
                case 3 -> {
//                    productService.createAndAddProduct(Double.parseDouble(words[1]), words[2],
//                            words[3]);
                }
                case 4 -> productService.removeProduct(Integer.parseInt(words[1]));

                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }
}


