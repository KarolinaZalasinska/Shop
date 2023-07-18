package org.example;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private ProductService productService;

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

    }

    public void showCategorySubMenu() {

    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista produktów");
            System.out.println("[2] Konkretny produkt");
            System.out.println("[3] Dodaj produkt");
            System.out.println("[4] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");

            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> productService.getAllProducts();
                case 2 -> {
                    productService.getProductById(Integer.parseInt(words[1]));
                }
                case 3 -> {
                    productService.addProduct(words[1], words[2], words[3], words[4]);
                }
                case 4 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }
}