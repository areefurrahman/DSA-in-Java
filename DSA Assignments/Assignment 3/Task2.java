class Record {
    int id;
    String name;
    Record left, right;

    public Record(int id, String name) {
        this.id = id;
        this.name = name;
        left = right = null;
    }

    @Override
    public String toString() {
        return " ----------------------------\n" +
               " >> Patient ID: " + id + "\n >> Patient Name: " + name;
    }
}

class HospitalSystem {
    public Record head;

    public Record addPatient(Record head, int id, String name) {
        if (head == null) {
            System.out.println("Patient added: ID (" + id + "), Name: " + name);
            return new Record(id, name);
        } else if (id < head.id) {
            head.left = addPatient(head.left, id, name);
        } else if (id > head.id) {
            head.right = addPatient(head.right, id, name);
        } else {
            System.out.println("Duplicate ID! Patient with ID " + id + " already exists.");
        }
        return head;
    }

    public Record removePatient(Record head, int id) {
        if (head == null) return null;

        if (id < head.id) {
            head.left = removePatient(head.left, id);
        } else if (id > head.id) {
            head.right = removePatient(head.right, id);
        } else {
            // One or no child
            if (head.left == null) return head.right;
            if (head.right == null) return head.left;

            // Two children
            head.id = findMin(head.right);
            head.right = removePatient(head.right, head.id);
        }
        return head;
    }

    int findMin(Record head) {
        int minId = head.id;
        while (head.left != null) {
            minId = head.left.id;
            head = head.left;
        }
        return minId;
    }

    public boolean findPatient(Record head, int id) {
        if (head == null) {
            System.out.println("No record found for the given ID.");
            return false;
        }
        if (id == head.id) {
            System.out.println("Record located:\n" + head);
            return true;
        } else if (id < head.id) {
            return findPatient(head.left, id);
        } else {
            return findPatient(head.right, id);
        }
    }

    public void showAllPatients(Record head) {
        if (head != null) {
            showAllPatients(head.left);
            System.out.println(head);
            showAllPatients(head.right);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();

        hs.head = hs.addPatient(hs.head, 1, "Ahsan");
        hs.head = hs.addPatient(hs.head, 5, "Farhan");
        hs.head = hs.addPatient(hs.head, 2, "Bilal");
        hs.head = hs.addPatient(hs.head, 4, "Tariq");
        hs.head = hs.addPatient(hs.head, 3, "Zubair");

        System.out.println("\nAll patient records (before deletion):");
        hs.showAllPatients(hs.head);

        System.out.println("\nRemoving patient with ID 4:");
        hs.head = hs.removePatient(hs.head, 4);

        System.out.println("\nAll patient records (after deletion):");
        hs.showAllPatients(hs.head);

        System.out.println("\nLooking for patient with ID 3:");
        hs.findPatient(hs.head, 3);
    }
}
