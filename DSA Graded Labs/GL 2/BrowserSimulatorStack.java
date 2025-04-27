import java.util.Scanner;
import java.util.Stack;

public class BrowserSimulatorStack {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;
    private Scanner scanner;

    public BrowserSimulatorStack() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = null;
        scanner = new Scanner(System.in);
    }

    public void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
    }

    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
    }

    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
    }

    public String showCurrentPage() {
        return currentPage != null ? currentPage : "No pages visited";
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
            scanner.nextLine();

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
        BrowserSimulatorStack simulator = new BrowserSimulatorStack();
        simulator.run();
    }
}