import java.io.*;
import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

   
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author +
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, Long> borrowRecords = new HashMap<>(); // To track borrowed books and their dates.

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Remove a book
    public void removeBook(String bookId) {
        books.removeIf(book -> book.getBookId().equals(bookId));
        System.out.println("Book removed successfully.");
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Borrow a book
    public void borrowBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId) && book.isAvailable()) {
                book.borrowBook();
                borrowRecords.put(bookId, System.currentTimeMillis());
                System.out.println("You have borrowed the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available or does not exist.");
    }

    // Return a book
    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId) && !book.isAvailable()) {
                book.returnBook();
                long borrowedTime = borrowRecords.getOrDefault(bookId, 0L);
                long currentTime = System.currentTimeMillis();
                long days = (currentTime - borrowedTime) / (1000 * 60 * 60 * 24);

                double fine = days > 7 ? (days - 7) * 5 : 0; // Rs. 5 fine for each day after 7 days.
                borrowRecords.remove(bookId);

                System.out.println("Book returned successfully.");
                if (fine > 0) {
                    System.out.println("Late fine: Rs. " + fine);
                }
                return;
            }
        }
        System.out.println("Invalid book ID or the book was not borrowed.");
    }
}

 class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;
                case 2:
                    System.out.println("Enter Book ID to remove: ");
                    bookId = scanner.nextLine();
                    library.removeBook(bookId);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Enter Book ID to borrow: ");
                    bookId = scanner.nextLine();
                    library.borrowBook(bookId);
                    break;
                case 5:
                    System.out.println("Enter Book ID to return: ");
                    bookId = scanner.nextLine();
                    library.returnBook(bookId);
                    break;
                case 6:
                    System.out.println("Exiting Library System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}