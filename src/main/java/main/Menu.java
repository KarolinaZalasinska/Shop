package main;

import model.Category;
import model.Customer;
import model.Order;
import model.OrderStatus;
import model.Product;
import service.CategoryService;
import service.OrderService;
import service.ProductService;

import java.util.Arrays;
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
		productsMap.put(productService.getProductByIdOrName(1, "Dress"), 5);
		productsMap.put(productService.getProductByIdOrName(2, "Heels"), 3);
		productsMap.put(productService.getProductByIdOrName(3, "Cap"), 2);
		productsMap.put(productService.getProductByIdOrName(4, "Earrings"), 1);

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
				case 1 -> showOrderServiceMenu();
				case 2 -> showCategoryServiceMenu();
				case 3 -> showProductServiceMenu();
				case 4 -> exit = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}

			System.out.println();
		}
	}

	public void showOrderServiceMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista zamówień");
			System.out.println("[2,orderNumber] Konkretne zamówienie");
			System.out.println("[3,firstName,lastName,address,orderStatus,productId1:quantity1,productId2:quantity2,...] Dodaj zamówienie");
			System.out.println("[4,orderNumber] Usuń zamówienie");
			System.out.println("[5,orderNumber,newStatus] Zaktualizuj status zamówienia");
			System.out.println("[6] Cofnij");

			final String choice = scanner.next();
			final String[] words = choice.split(",");
			scanner.nextLine();

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(orderService.getAllOrders());
				case 2 -> {
					final int orderNumberIndex = 1;
					final Order order = orderService.findOrder(words[orderNumberIndex]);
					if (order != null) {
						System.out.println(order);
					} else {
						System.out.println("Zamówienie o podanym numerze nie istnieje.");
					}
				}
				case 3 -> {
					if (words.length < 4) {
						System.out.println("Nieprawidłowe dane. Podaj dane klienta, status zamówienia i co najmniej jeden produkt.");
						break;
					}

					final String firstName = words[1];
					final String lastName = words[2];
					final String address = words[3];
					final OrderStatus orderStatus = OrderStatus.valueOf(words[4].toUpperCase());

					final Map<Product, Integer> productsMap = new HashMap<>();
					Arrays.stream(words).skip(4).forEach(word -> {
						final String[] productQuantity = word.split(":");
						final int productId = Integer.parseInt(productQuantity[0]);
						final String prod = productQuantity[1];
						final int quantity = Integer.parseInt(productQuantity[2]);

						final Product product = productService.getProductByIdOrName(productId, prod);
						if (product != null) {
							productsMap.put(product, quantity);
						} else {
							System.out.println("Produkt o ID/nazwie " + productId + "/" + prod + " nie istnieje.");
						}
					});

					final Customer customer = new Customer(firstName, lastName, address);
					orderService.createAndAddOrder(customer, orderStatus, productsMap);
					System.out.println("Dodano nowe zamówienie.");
				}
				case 4 -> {
					final int orderNumberIndex = 1;
					final boolean orderRemoved = orderService.removeOrderByNumber(words[orderNumberIndex]);
					if (orderRemoved) {
						System.out.println("Usunięto zamówienie o numerze: " + words[orderNumberIndex]);
					} else {
						System.out.println("Zamówienie o podanym numerze nie istnieje.");
					}
				}
				case 5 -> {
					final int orderNumberIndex = 1;
					final OrderStatus newStatus = OrderStatus.valueOf(words[2].toUpperCase());
					final boolean updated = orderService.updatedOrderStatus(words[orderNumberIndex], newStatus);
					if (updated) {
						System.out.println("Zaktualizowano status zamówienia o numerze: " + words[orderNumberIndex]);
					} else {
						System.out.println("Zamówienie o podanym numerze nie istnieje.");
					}
				}
				case 6 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}

			System.out.println();
		}
	}


	public void showCategoryServiceMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista kategorii");
			System.out.println("[2,categoryId,categoryName] Konkretna kategoria");
			System.out.println("[3,name] Dodaj kategorię");
			System.out.println("[4,categoryId] Usuń kategorię");
			System.out.println("[5] Cofnij");

			final String choice = scanner.next();
			final String[] words = choice.split(",");
			scanner.nextLine();

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(categoryService.getAllCategories());
				case 2 -> {
					final int categoryIdIndex = 1;
					final int categoryNameIndex = 2;
					final Category category = categoryService.getCategoryByIdOrName(
							Integer.parseInt(words[categoryIdIndex]),
							words[categoryNameIndex]);
					if (category != null) {
						System.out.println(category);
					} else {
						System.out.println("Kategoria o podanym ID lub nazwie nie istnieje.");
					}
				}
				case 3 -> {
					if (words.length < 2) {
						System.out.println("Nieprawidłowe dane. Podaj nazwę kategorii.");
						break;
					}
					final String name = words[1];
					final Category newCategory = categoryService.createAndAddCategory(name);
					System.out.println("Dodano nową kategorię: " + newCategory);
				}
				case 4 -> {
					final int categoryIdIndex = 1;
					final boolean categoryRemoved = categoryService.removeCategory(Integer.parseInt(words[categoryIdIndex]));
					if (categoryRemoved) {
						System.out.println("Usunięto kategorię o ID: " + words[categoryIdIndex]);
					} else {
						System.out.println("Kategoria o podanym ID nie istnieje.");
					}
				}
				case 5 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}

			System.out.println();
		}
	}


	public void showProductServiceMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista produktów");
			System.out.println("[2,productId,productName] Konkretny produkt");
			System.out.println("[3,price,name,category] Dodaj produkt");
			System.out.println("[4,productId] Usuń produkt ");
			System.out.println("[5] Cofnij");

			final String choice = scanner.next();
			final String[] words = choice.split(",");
			scanner.nextLine();

			switch (Integer.parseInt(words[0])) {
				case 1 -> System.out.println(productService.getAllProducts());
				case 2 -> {
					final int productIdIndex = 1;
					final int productNameIndex = 2;
					final Product product = productService.getProductByIdOrName(
							Integer.parseInt(words[productIdIndex]),
							words[productNameIndex]);
					if (product != null) {
						System.out.println(product);
					} else {
						System.out.println("Produkt o podanym ID lub nazwie nie istnieje.");
					}
				}
				case 3 -> {
					if (words.length < 4) {
						System.out.println("Nieprawidłowe dane. Podaj cenę, nazwę i kategorię produktu.");
						break;
					}
					final double price = Double.parseDouble(words[1]);
					final String name = words[2];
					final String category = words[3];
					final Category foundCategory = categoryService.getCategoryByIdOrName(0, category);
					if (foundCategory == null) {
						System.out.println("Kategoria o podanej nazwie nie istnieje.");
						break;
					}
					productService.createAndAddProduct(price, name, foundCategory);
					System.out.println("Dodano nowy produkt.");
				}
				case 4 -> {
					final int productIdIndex = 1;
					final boolean productRemoved = productService.removeProduct(Integer.parseInt(words[productIdIndex]));
					if (productRemoved) {
						System.out.println("Usunięto produkt o ID: " + words[productIdIndex]);
					} else {
						System.out.println("Produkt o podanym ID nie istnieje.");
					}
				}
				case 5 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}

			System.out.println();
		}
	}
}
