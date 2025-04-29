import java.util.*;

// ------------------- Custom Circular Queue -----------------------
class RiderNode {
    String name;
    RiderNode next;

    RiderNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class RollerCoasterQueue {
    private RiderNode front = null;
    private RiderNode rear = null;

    // Add rider to end
    public void addRider(String name) {
        RiderNode newNode = new RiderNode(name);
        if (front == null) {
            front = rear = newNode;
            rear.next = front; // make it circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    // Remove rider from front
    public void removeRider() {
        if (front == null) {
            System.out.println("No riders in the queue.");
            return;
        }

        String removed = front.name;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        System.out.println("Rider finished the ride: " + removed);
    }

    // Display all riders
    public void displayRiders() {
        if (front == null) {
            System.out.println("No riders in the queue.");
            return;
        }

        System.out.println("Current Riders in Queue:");
        RiderNode current = front;
        do {
            System.out.println("- " + current.name);
            current = current.next;
        } while (current != front);
    }
}

// ------------------- VIP Guest Movement -----------------------
class VIPGuest {
    String name;
    String attraction;

    VIPGuest(String name, String attraction) {
        this.name = name;
        this.attraction = attraction;
    }

    @Override
    public String toString() {
        return name + " at " + attraction;
    }
}

public class ThemeParkSystem {
    public static void main(String[] args) {

        // Part 1: VIP Guest Trail (use LinkedList)
        LinkedList<VIPGuest> vipTrail = new LinkedList<>();

        // Add 4 VIP guests
        vipTrail.add(new VIPGuest("Ali", "Haunted House"));
        vipTrail.add(new VIPGuest("Zoya", "Ferris Wheel"));
        vipTrail.add(new VIPGuest("Ahmed", "Magic Show"));
        vipTrail.add(new VIPGuest("Sara", "Jungle Safari"));

        // Display forward
        System.out.println("VIP Guests (Forward):");
        for (VIPGuest guest : vipTrail) {
            System.out.println("- " + guest);
        }

        // Display backward
        System.out.println("\nVIP Guests (Backward):");
        ListIterator<VIPGuest> backwardIterator = vipTrail.listIterator(vipTrail.size());
        while (backwardIterator.hasPrevious()) {
            System.out.println("- " + backwardIterator.previous());
        }

        // Remove 1 VIP guest (e.g., Ahmed)
        String nameToRemove = "Ahmed";
        for (int i = 0; i < vipTrail.size(); i++) {
            if (vipTrail.get(i).name.equalsIgnoreCase(nameToRemove)) {
                vipTrail.remove(i);
                break;
            }
        }

        // Display again forward
        System.out.println("\nVIP Guests (Forward) after removal:");
        for (VIPGuest guest : vipTrail) {
            System.out.println("- " + guest);
        }

        // Part 2: Roller Coaster Circular Queue
        RollerCoasterQueue rideQueue = new RollerCoasterQueue();

        // Add 5 riders
        rideQueue.addRider("Bilal");
        rideQueue.addRider("Tania");
        rideQueue.addRider("Usman");
        rideQueue.addRider("Areeba");
        rideQueue.addRider("Hamza");

        // Remove 2 riders
        rideQueue.removeRider();
        rideQueue.removeRider();

        // Display remaining riders
        System.out.println();
        rideQueue.displayRiders();
    }
}
