package main;

import model.Customer;
import model.OrderStatus;
import model.Product;
import service.CategoryService;
import service.OrderService;
import service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

	private final Scanner scanner = new Scanner(System.in);
	private final ProductService productService = new ProductService();
	private final CategoryService categoryService = new CategoryService();
	private final OrderService orderService = new OrderService();

	{
		createCategories();
		createProducts(); //blok inicjaliz. danych
		createOrders();

	}

	public void createOrders() {
		final Map<Product, Integer> productsMap = new HashMap<>();
		productsMap.put(productService.getProductById(1), 5);
		productsMap.put(productService.getProductById(2), 3);
		productsMap.put(productService.getProductById(3), 2);
		productsMap.put(productService.getProductById(4), 1);

		final Customer customer1 = new Customer("Anna", "Nowak", "Kryształowa 7, 48 - 300 Nysa");
		final Customer customer2 = new Customer("Adam", "Nowak", "Kryształowa 7, 48 - 300 Nysa");
		final Customer customer3 = new Customer("Tomasz", "Kowalski", "Lazurowa 1, 48 - 300 Nysa");
		final Customer customer4 = new Customer("Joanna", "Kowalska", "Lazurowa 1, 48 - 300 Nysa");

		orderService.createAndAddOrder(customer1, OrderStatus.PREPARING, productsMap);
		orderService.createAndAddOrder(customer2, OrderStatus.PAID, productsMap);
		orderService.createAndAddOrder(customer3, OrderStatus.SHIPPED, productsMap);
		orderService.createAndAddOrder(customer4, OrderStatus.PREPARING, productsMap);
	}

	public void createCategories() {
		categoryService.createAndAddCategory("Clothing");
		categoryService.createAndAddCategory("Footwear");
		categoryService.createAndAddCategory("Accessories");
	}

	public void createProducts() {
		productService.createAndAddProduct(199.99, "Dress", categoryService.getAllCategories().get(0));
		productService.createAndAddProduct(149.99, "Heels", categoryService.getAllCategories().get(1));
		productService.createAndAddProduct(39.99, "Cap", categoryService.getAllCategories().get(2));
		productService.createAndAddProduct(79.99, "Trousers", categoryService.getAllCategories().get(1));
		productService.createAndAddProduct(249.99, "Sneakers", categoryService.getAllCategories().get(1));
		productService.createAndAddProduct(19.99, "Hat", categoryService.getAllCategories().get(2));
		productService.createAndAddProduct(79.99, "Earrings", categoryService.getAllCategories().get(2));
	}


	public void showMainMenu() {
		boolean exit = false;
		while (!exit) {
			System.out.println("[1] Zamówienia");
			System.out.println("[2] Kategorie produktów");
			System.out.println("[3] Produkty");
			System.out.println("[4] Wyjdź");

			final int choice = scanner.nextInt();
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
			System.out.println("[3] Utwórz i dodaj zamówienie");
			System.out.println("[4,OrderNumber] Zmień status zamówienia");
			System.out.println("[5,OrderNumber] Usuń zamówienie");
			System.out.println("[6] Cofnij");

			final String choice = scanner.nextLine();
			final String[] words = choice.split(",");

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(orderService.getAllOrders());
				case 2 -> System.out.println(orderService.findOrder(words[1]));
				case 3 -> {
					System.out.println("Podaj imię klienta:");
					final String firstName = scanner.nextLine();

					System.out.println("Podaj nazwisko klienta:");
					final String lastName = scanner.nextLine();

					System.out.println("Podaj adres klienta:");
					final String address = scanner.nextLine();

					System.out.println("Podaj status zamówienia (PREPARING, PAID, SHIPPED, CANCELED): ");
					final OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine());

					final Customer customer = new Customer(firstName, lastName, address);

					final Map<Product, Integer> productsMap = new HashMap<>();

					orderService.createAndAddOrder(customer, orderStatus, productsMap);
				}
				case 4 -> {
					System.out.println("Podaj numer zamówienia: ");
					final String orderNumber = scanner.nextLine();

					System.out.println("Podaj nowy status zamówienia (PREPARING, PAID, SHIPPED, CANCELED, ): ");
					final OrderStatus newStatus = OrderStatus.valueOf(scanner.nextLine());

					if (orderService.changeOrderStatus(orderNumber, newStatus)) {
						System.out.println("Status zamówienia został zmieniony.");
					} else {
						System.out.println("Nie udało się zmienić statusu zamówienia. Sprawdź poprawność numeru zamówienia.");
					}
				}
				case 5 -> {
					orderService.removeOrderByNumber(words[1]);
					System.out.println("Zamówienie o numerze " + words[1] + " zostało usunięte.");
				}
				case 6 -> back = true;
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

			final String choice = scanner.next();
			final String[] words = choice.split(",");
			scanner.nextLine();

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(categoryService.getAllCategories());
				case 2 ->
						System.out.println(categoryService.getCategoryByIdOrName(Integer.parseInt(words[1]), words[2]));
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

			final String choice = scanner.next();
			final String[] words = choice.split(",");
			scanner.nextLine();

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(productService.getAllProducts());
				case 2 -> System.out.println(productService.getProductById(Integer.parseInt(words[1])));
				case 3 -> {
//                    System.out.println(productService.createAndAddProduct(Double.parseDouble(words[1]), words[2],
//                            words[3]));
				}
				case 4 -> productService.removeProduct(Integer.parseInt(words[1]));
				case 5 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}

			System.out.println();
		}
	}
}
