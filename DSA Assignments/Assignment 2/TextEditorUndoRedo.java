import java.util.Scanner;
import java.util.Stack;

public class TextEditorUndoRedo {

    private static Scanner input = new Scanner(System.in);
    private static Stack<String> undo = new Stack<>();
    private static Stack<String> redo = new Stack<>();

    public static void addText() {
        System.out.print("Enter String: ");
        String text = input.nextLine();
        undo.push(text);
        redo.clear();
        System.out.println("Text added.");
    }

    public static void deleteText() {
        if (!undo.isEmpty()) {
            String text = undo.pop();
            redo.push(text);
            System.out.println("Last text deleted.");
        } else {
            System.out.println("Nothing to delete.");
        }
    }

    public static void undoAction() {
        if (!undo.isEmpty()) {
            String text = undo.pop();
            redo.push(text);
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public static void redoAction() {
        if (!redo.isEmpty()) {
            String text = redo.pop();
            undo.push(text);
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public static void displayText() {
        if (!undo.isEmpty()) {
            String text = undo.peek();
            System.out.println("Current Text: " + text);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void displayHistory() {
        System.out.println("\n--- Undo Stack (History) ---");
        if (undo.isEmpty()) {
            System.out.println("No text history.");
        } else {
            for (String text : undo) {
                System.out.println(text);
            }
        }

        System.out.println("\n--- Redo Stack ---");
        if (redo.isEmpty()) {
            System.out.println("No redo history.");
        } else {
            for (String text : redo) {
                System.out.println(text);
            }
        }
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("\nText Undo Redo Menu:");
        System.out.println("1. Add Text");
        System.out.println("2. Delete Text");
        System.out.println("3. Undo");
        System.out.println("4. Redo");
        System.out.println("5. Display Current Text");
        System.out.println("6. Display History");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addText();
                    break;
                case 2:
                    deleteText();
                    break;
                case 3:
                    undoAction();
                    break;
                case 4:
                    redoAction();
                    break;
                case 5:
                    displayText();
                    break;
                case 6:
                    displayHistory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
