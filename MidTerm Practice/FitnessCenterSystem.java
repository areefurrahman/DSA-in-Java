import java.util.*;

// Part 1: Equipment Catalog using Custom Singly Linked List
class EquipmentNode {
    String name;
    String type;
    EquipmentNode next;

    public EquipmentNode(String name, String type) {
        this.name = name;
        this.type = type;
        this.next = null;
    }
}

class EquipmentCatalog {
    private EquipmentNode head;

    // Add equipment at the end
    public void addEquipment(String name, String type) {
        EquipmentNode newNode = new EquipmentNode(name, type);
        if (head == null) {
            head = newNode;
        } else {
            EquipmentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove equipment by name
    public void removeEquipment(String name) {
        if (head == null) return;

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            return;
        }

        EquipmentNode current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Display all equipment
    public void displayEquipment() {
        if (head == null) {
            System.out.println("No equipment in the catalog.");
            return;
        }
        EquipmentNode current = head;
        System.out.println("Available Equipment Catalog:");
        while (current != null) {
            System.out.println("- " + current.name + " (" + current.type + ")");
            current = current.next;
        }
    }
}

// Main class
public class FitnessCenterSystem {
    public static void main(String[] args) {

        // Part 1: Borrowed Equipment Management using Stack
        Stack<String> borrowedEquipment = new Stack<>();

        // Part 2: Membership Management using ArrayList
        ArrayList<String> members = new ArrayList<>();

        // Part 3: Equipment Catalog Management using Custom Linked List
        EquipmentCatalog catalog = new EquipmentCatalog();

        // Task: Add 3 equipment items
        catalog.addEquipment("Treadmill", "Cardio");
        catalog.addEquipment("Dumbbells", "Strength");
        catalog.addEquipment("Skipping Rope", "Cardio");

        // Task: Register 4 gym members
        members.add("Ali");
        members.add("Sara");
        members.add("Zain");
        members.add("Hira");

        // Task: Unregister 2 members
        members.remove("Zain");
        members.remove("Hira");

        // Task: Simulate borrowing 3 pieces of equipment
        borrowedEquipment.push("Yoga Mat");
        borrowedEquipment.push("Dumbbells");
        borrowedEquipment.push("Skipping Rope");

        // Task: Simulate returning 1 piece of equipment (LIFO - last in first out)
        if (!borrowedEquipment.isEmpty()) {
            System.out.println("Returned Equipment: " + borrowedEquipment.pop());
        }

        // Display registered members
        System.out.println("\nCurrent Registered Members:");
        if (members.isEmpty()) {
            System.out.println("No registered members.");
        } else {
            for (String member : members) {
                System.out.println("- " + member);
            }
        }

        // Display borrowed equipment
        System.out.println("\nCurrent borrowed equipment (top is most recent):");
        if (borrowedEquipment.isEmpty()) {
            System.out.println("No equipment currently borrowed.");
        } else {
            for (int i = borrowedEquipment.size() - 1; i >= 0; i--) {
                System.out.println("- " + borrowedEquipment.get(i));
            }
        }

        // Display equipment catalog
        System.out.println();
        catalog.displayEquipment();
    }
}
