import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

 
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: ₹" + price + ", Quantity: " + quantity;
    }
}

class User {
    private String username;
    private String password;
    private List<Product> cart = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= product.getQuantity()) {
            cart.add(new Product(product.getId(), product.getName(), product.getPrice(), quantity));
            product.reduceQuantity(quantity);
            System.out.println(quantity + " " + product.getName() + " added to cart.");
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    public void viewCart() {
        System.out.println("Your Cart:");
        for (Product product : cart) {
            System.out.println(product);
        }
    }

    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Order placed successfully!");
            cart.clear();
        }
    }
}

class EcommerceSystem {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("User registered successfully.");
    }
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcommerceSystem system = new EcommerceSystem();

        system.addProduct(new Product(1, "Laptop", 50000, 10));
        system.addProduct(new Product(2, "Smartphone", 20000, 15));
        system.addProduct(new Product(3, "Headphones", 2000, 50));

        User currentUser = null;

        while (true) {
            System.out.println("\nE-Commerce System:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    system.registerUser(username, password);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    currentUser = system.loginUser(username, password);
                    break;

                case 3:
                    system.displayProducts();
                    break;

                case 4:
                    if (currentUser != null) {
                        system.displayProducts();
                        System.out.print("Enter product ID: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        Product product = system.findProductById(productId);
                        if (product != null) {
                            currentUser.addToCart(product, quantity);
                        } else {
                            System.out.println("Product not found.");
                        }
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;

                case 5:
                    if (currentUser != null) {
                        currentUser.viewCart();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;

                case 6:
                    if (currentUser != null) {
                        currentUser.placeOrder();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}