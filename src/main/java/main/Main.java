package main;

import service.ProductService;

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
        boolean back = false;
        while (!back) {

        }
    }

    public void showCategorySubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista kategorii");
            System.out.println("[2] Konkretna kategoria");
            System.out.println("[3] Dodaj kategorie");
            System.out.println("[4] Usuń kategorie");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");

            scanner.nextLine();

//            switch (Integer.parseInt(words[0])) {
//                case 1 -> ;
//                case 2 -> ;
//                case 3 -> ;
//                case 4 -> ;
//                case 5 -> back = true;
//                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
//            }
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista produktów");
            System.out.println("[2] Konkretny produkt");
            System.out.println("[3] Dodaj produkt");
            System.out.println("[4] Usuń produkt ");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");

            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> productService.getAllProducts();
                case 2 -> productService.getProductById(Integer.parseInt(words[1]));
                case 3 -> {
//                    productService.addProduct(Double.parseDouble(words[1]), words[2],
//                            words[3], Integer.parseInt(words[4]));
                }
                case 4 -> productService.removeProduct(Integer.parseInt(words[1]));

                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }
}


