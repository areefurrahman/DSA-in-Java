import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    String name;
    String issueDescription;

    Customer(String name, String issueDescription) {
        this.name = name;
        this.issueDescription = issueDescription;
    }
}

class HelpdeskQueue {
    private Queue<Customer> queue = new LinkedList<>();

    public void enqueue(String name, String issueDescription) {
        if (name.isBlank() || issueDescription.isBlank()) {
            System.out.println("Error: Name and Issue Description cannot be blank.");
            return;
        }
        Customer customer = new Customer(name, issueDescription);
        queue.add(customer);
        System.out.println("Customer added to the queue.");
    }

    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. No customer to serve.");
        } else {
            Customer servedCustomer = queue.poll();
            System.out.println("Serving Customer: " + servedCustomer.name);
            System.out.println("Issue: " + servedCustomer.issueDescription);
        }
    }

    public void peek() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            Customer nextCustomer = queue.peek();
            System.out.println("Next Customer: " + nextCustomer.name);
            System.out.println("Issue: " + nextCustomer.issueDescription);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Customers in Queue:");
            for (Customer customer : queue) {
                System.out.println("- " + customer.name + ": " + customer.issueDescription);
            }
        }
    }
}

public class HelpdeskSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HelpdeskQueue helpdesk = new HelpdeskQueue();

        while (true) {
            System.out.println("\nHelpdesk Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Display All Customers");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Issue Description: ");
                    String issue = scanner.nextLine();
                    helpdesk.enqueue(name, issue);
                    break;
                case 2:
                    helpdesk.dequeue();
                    break;
                case 3:
                    helpdesk.peek();
                    break;
                case 4:
                    if (helpdesk.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is NOT empty.");
                    }
                    break;
                case 5:
                    helpdesk.displayQueue();
                    break;
                case 6:
                    System.out.println("Exiting Helpdesk System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
