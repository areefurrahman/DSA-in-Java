import java.util.LinkedList;
import java.util.Scanner;

// -------- PART 2: Custom Circular Queue for Boarding --------
class PassengerNode {
    String name;
    PassengerNode next;

    public PassengerNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class CircularBoardingQueue {
    private PassengerNode front = null;
    private PassengerNode rear = null;

    // Add passenger at end
    public void addPassenger(String name) {
        PassengerNode newNode = new PassengerNode(name);
        if (front == null) {
            front = rear = newNode;
            rear.next = front; // make it circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    // Remove passenger from front
    public void removePassenger() {
        if (front == null) {
            System.out.println("No passengers in the boarding queue.");
            return;
        }

        String removedName = front.name;

        if (front == rear) { // only one passenger
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        System.out.println("Passenger boarded: " + removedName);
    }

    // Display passengers
    public void displayPassengers() {
        if (front == null) {
            System.out.println("No passengers in the boarding queue.");
            return;
        }

        System.out.println("Passengers waiting to board:");
        PassengerNode current = front;
        do {
            System.out.println("- " + current.name);
            current = current.next;
        } while (current != front);
    }
}

// -------- PART 1: VIP Lounge Movement using LinkedList --------
class VIPPassenger {
    String name;
    String lounge;

    public VIPPassenger(String name, String lounge) {
        this.name = name;
        this.lounge = lounge;
    }

    @Override
    public String toString() {
        return name + " at " + lounge;
    }
}

public class AirportManagementSystem {
    public static void main(String[] args) {

        // Part 1: VIP Lounge Trail using Java's LinkedList
        LinkedList<VIPPassenger> vipTrail = new LinkedList<>();

        // Add 4 VIP passengers
        vipTrail.add(new VIPPassenger("Ali", "Emerald Lounge"));
        vipTrail.add(new VIPPassenger("Sara", "Gold Lounge"));
        vipTrail.add(new VIPPassenger("Zain", "Platinum Lounge"));
        vipTrail.add(new VIPPassenger("Hira", "Diamond Lounge"));

        // Display VIP forward
        System.out.println("VIP Passengers (Forward):");
        for (VIPPassenger vip : vipTrail) {
            System.out.println("- " + vip);
        }

        // Display VIP backward
        System.out.println("\nVIP Passengers (Backward):");
        for (int i = vipTrail.size() - 1; i >= 0; i--) {
            System.out.println("- " + vipTrail.get(i));
        }

        // Remove 1 VIP passenger by name
        String nameToRemove = "Zain";
        for (int i = 0; i < vipTrail.size(); i++) {
            VIPPassenger vip = vipTrail.get(i);
            if (vip.name.equalsIgnoreCase(nameToRemove)) {
                vipTrail.remove(i);
                break;
            }
        }

        // Display again after removal
        System.out.println("\nVIP Passengers (Forward) after removal:");
        for (VIPPassenger vip : vipTrail) {
            System.out.println("- " + vip);
        }

        // Part 2: Boarding Queue using Circular Linked List
        CircularBoardingQueue boardingQueue = new CircularBoardingQueue();

        // Add 5 passengers to boarding queue
        boardingQueue.addPassenger("Ahmed");
        boardingQueue.addPassenger("Fatima");
        boardingQueue.addPassenger("Usman");
        boardingQueue.addPassenger("Areeba");
        boardingQueue.addPassenger("Bilal");

        // Remove 2 passengers after boarding
        boardingQueue.removePassenger();
        boardingQueue.removePassenger();

        // Display remaining passengers
        System.out.println();
        boardingQueue.displayPassengers();
    }
}
