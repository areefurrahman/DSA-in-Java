import java.util.Scanner;

class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class BrowserSimulatorLinkedList {
    private Node head;
    private Node current;
    private Scanner scanner;

    public BrowserSimulatorLinkedList() {
        head = null;
        current = null;
        scanner = new Scanner(System.in);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            // Remove forward history
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
            current = newNode;
        }
    }

    // previous page
    public void back() {
        if (current.prev != null) {
            current = current.prev;
        }
    }

    // forward to the next page
    public void forward() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public String showCurrentPage() {
        if (current == null) {
            return "No pages visited";
        }
        return current.data;
    }

    public void displayMenu() {
        System.out.println("Browser Simulator Menu:");
        System.out.println("1. Visit a new page");
        System.out.println("2. Go back");
        System.out.println("3. Go forward");
        System.out.println("4. Show current page");
        System.out.println("5. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    visit(url);
                    System.out.println("Visited: " + url);
                    break;
                case 2:
                    back();
                    System.out.println("Went back to: " + showCurrentPage());
                    break;
                case 3:
                    forward();
                    System.out.println("Went forward to: " + showCurrentPage());
                    break;
                case 4:
                    System.out.println("Current Page: " + showCurrentPage());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BrowserSimulatorLinkedList simulator = new BrowserSimulatorLinkedList();
        simulator.run();
    }
}