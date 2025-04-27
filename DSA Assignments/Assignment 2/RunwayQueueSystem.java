import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Aircraft {
    String flightNumber;
    String destination;

    Aircraft(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }
}

class RunwaySystem {
    private Queue<Aircraft> queue = new LinkedList<>();

    private boolean flightExists(String flightNumber) {
        for (Aircraft aircraft : queue) {
            if (aircraft.flightNumber.equalsIgnoreCase(flightNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addFlight(String flightNumber, String destination) {
        if (flightNumber.isBlank() || destination.isBlank()) {
            System.out.println("Error: Flight number and destination cannot be blank.");
            return;
        }
        if (flightExists(flightNumber)) {
            System.out.println("Error: Flight number already exists.");
            return;
        }
        Aircraft newFlight = new Aircraft(flightNumber, destination);
        queue.add(newFlight);
        System.out.println("Flight added to queue successfully.");
    }

    public void authorizeTakeoff() {
        if (queue.isEmpty()) {
            System.out.println("No flights waiting for takeoff.");
        } else {
            Aircraft flight = queue.poll();
            System.out.println("Flight " + flight.flightNumber + " to " + flight.destination + " is authorized for takeoff!");
        }
    }

    public void peekNextFlight() {
        if (queue.isEmpty()) {
            System.out.println("No flights waiting.");
        } else {
            Aircraft nextFlight = queue.peek();
            System.out.println("Next flight: " + nextFlight.flightNumber + " heading to " + nextFlight.destination);
        }
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("No flights waiting.");
        } else {
            System.out.println("Flights in Queue:");
            for (Aircraft aircraft : queue) {
                System.out.println("- " + aircraft.flightNumber + " -> " + aircraft.destination);
            }
        }
    }
}

public class RunwayQueueSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RunwaySystem runway = new RunwaySystem();

        while (true) {
            System.out.println("\nRunway System Menu:");
            System.out.println("1. Add Flight");
            System.out.println("2. Authorize Takeoff");
            System.out.println("3. View Next Flight");
            System.out.println("4. Display All Flights");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    runway.addFlight(flightNumber, destination);
                    break;
                case 2:
                    runway.authorizeTakeoff();
                    break;
                case 3:
                    runway.peekNextFlight();
                    break;
                case 4:
                    runway.displayQueue();
                    break;
                case 5:
                    System.out.println("Exiting Runway System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
