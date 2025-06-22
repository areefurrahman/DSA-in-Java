class Node {
    int code;
    String name, writer;
    Node left, right;

    public Node(int code, String name, String writer) {
        this.code = code;
        this.name = name;
        this.writer = writer;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "--------------------------\n" +
               " Book Code: " + code +
               "\n Book Name: " + name +
               "\n Writer: " + writer;
    }
}

class BookTree {
    public Node start;

    public Node insert(Node start, int code, String name, String writer) {
        if (start == null) {
            System.out.println("Book added: " + code);
            return new Node(code, name, writer);
        } else if (code < start.code) {
            start.left = insert(start.left, code, name, writer);
        } else if (code > start.code) {
            start.right = insert(start.right, code, name, writer);
        } else {
            System.out.println("Book with code " + code + " already in the system!");
        }
        return start;
    }

    public boolean find(Node start, int code) {
        if (start == null) {
            System.out.println("No book found.");
            return false;
        }
        if (code == start.code) {
            System.out.println("Book located!\nDetails:\n" + start);
            return true;
        } else if (code < start.code) {
            return find(start.left, code);
        } else {
            return find(start.right, code);
        }
    }

    public void showBooks(Node start) {
        if (start != null) {
            showBooks(start.left);
            System.out.println(start);
            showBooks(start.right);
        }
    }

    public Node remove(Node start, int code) {
        if (start == null) {
            System.out.println("Cannot delete. Book with code " + code + " not found!");
            return null;
        }

        if (code < start.code) {
            start.left = remove(start.left, code);
        } else if (code > start.code) {
            start.right = remove(start.right, code);
        } else {
            if (start.left == null) {
                System.out.println("Deleted book with code: " + code);
                return start.right;
            } else if (start.right == null) {
                System.out.println("Deleted book with code: " + code);
                return start.left;
            }

            Node smallest = findSmallest(start.right);
            start.code = smallest.code;
            start.name = smallest.name;
            start.writer = smallest.writer;

            start.right = remove(start.right, smallest.code);
        }
        return start;
    }

    private Node findSmallest(Node start) {
        while (start.left != null) {
            start = start.left;
        }
        return start;
    }
}

public class Task3 {
    public static void main(String[] args) {
        BookTree bt = new BookTree();

        bt.start = bt.insert(bt.start, 10, "Learn Java Basics", "Ali Raza");
        bt.start = bt.insert(bt.start, 15, "Web Dev Essentials", "Sara Khan");
        bt.start = bt.insert(bt.start, 5, "Programming in C", "Ahmed Zubair");
        bt.start = bt.insert(bt.start, 12, "Database Intro", "Zain Aslam");
        bt.start = bt.insert(bt.start, 3, "Logic Building", "Maira Tariq");

        System.out.println("\nTrying to add a duplicate:");
        bt.start = bt.insert(bt.start, 5, "Oops Again", "Unknown");

        System.out.println("\nSearching for Book Code = 12:");
        bt.find(bt.start, 12);

        System.out.println("\nAll Available Books:");
        bt.showBooks(bt.start);

        System.out.println("\nRemoving Book Code = 15:");
        bt.start = bt.remove(bt.start, 15);

        System.out.println("\nBooks After Deletion:");
        bt.showBooks(bt.start);
    }
}
