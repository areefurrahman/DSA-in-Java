import java.util.ArrayList;
import java.util.Scanner;

public class BrowserSimulatorArrayList {
    private ArrayList<String> history;
    private int currentIndex;
    private Scanner scanner;

    public BrowserSimulatorArrayList() {
        history = new ArrayList<>();
        currentIndex = -1;
        scanner = new Scanner(System.in);
    }

    public void visit(String url) {
        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }
        history.add(url);
        currentIndex++;
    }

    public void back() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public void forward() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
        }
    }

    public String showCurrentPage() {
        if (currentIndex == -1) {
            return "No pages visited";
        }
        return history.get(currentIndex);
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
        BrowserSimulatorArrayList simulator = new BrowserSimulatorArrayList();
        simulator.run();
    }
}