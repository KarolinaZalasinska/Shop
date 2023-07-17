package org.example;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista produktów");
            System.out.println("[2] Konkretny produkt");
            System.out.println("[3] Dodaj kategorie");
            System.out.println("[4] Cofnij");

            int choice = scanner.nextInt();


            scanner.nextLine();


        }
    }
}