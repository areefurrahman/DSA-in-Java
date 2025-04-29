import java.util.*;

// Custom Node for Book Catalog
class BookNode {
    String title;
    String author;
    BookNode next;

    BookNode(String title, String author) {
        this.title = title;
        this.author = author;
        this.next = null;
    }
}

// Custom Singly Linked List for Book Catalog
class BookCatalog {
    private BookNode head;

    // Add new book to catalog
    public void addBook(String title, String author) {
        BookNode newNode = new BookNode(title, author);
        if (head == null) {
            head = newNode;
        } else {
            BookNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove book by title
    public void removeBook(String title) {
        if (head == null) return;

        if (head.title.equalsIgnoreCase(title)) {
            head = head.next;
            return;
        }

        BookNode current = head;
        while (current.next != null && !current.next.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Display all books in catalog
    public void displayBooks() {
        if (head == null) {
            System.out.println("No books available in the catalog.");
            return;
        }

        System.out.println("Available Book Catalog:");
        BookNode current = head;
        while (current != null) {
            System.out.println("- " + current.title + " by " + current.author);
            current = current.next;
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Borrowed Books: LIFO (use Stack)
        Stack<String> borrowedBooks = new Stack<>();

        // Member list: use ArrayList
        ArrayList<String> members = new ArrayList<>();

        // Book Catalog: use custom linked list
        BookCatalog catalog = new BookCatalog();

        // Add 3 books to catalog
        catalog.addBook("The Alchemist", "Paulo Coelho");
        catalog.addBook("To Kill a Mockingbird", "Harper Lee");
        catalog.addBook("1984", "George Orwell");

        // Register 4 members
        members.add("Ali");
        members.add("Fatima");
        members.add("Ahmed");
        members.add("Zoya");

        // Unregister 2 members
        members.remove("Ahmed");
        members.remove("Zoya");

        // Borrow 3 books
        borrowedBooks.push("The Alchemist");
        borrowedBooks.push("1984");
        borrowedBooks.push("To Kill a Mockingbird");

        // Return 1 book (remove from top)
        if (!borrowedBooks.isEmpty()) {
            System.out.println("Returned Book: " + borrowedBooks.pop());
        }

        // Display current members
        System.out.println("\nCurrent Registered Members:");
        if (members.isEmpty()) {
            System.out.println("No registered members.");
        } else {
            for (String member : members) {
                System.out.println("- " + member);
            }
        }

        // Display borrowed books
        System.out.println("\nCurrent Borrowed Books (Most recent on top):");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
        } else {
            for (int i = borrowedBooks.size() - 1; i >= 0; i--) {
                System.out.println("- " + borrowedBooks.get(i));
            }
        }

        // Display catalog
        System.out.println();
        catalog.displayBooks();
    }
}
