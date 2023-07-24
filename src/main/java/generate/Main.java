package generate;

import main.Menu;
import model.Category;
import model.Order;
import model.OrderStatus;
import model.Product;
import service.CategoryService;
import service.OrderService;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Menu().showMainMenu();
    }

}
