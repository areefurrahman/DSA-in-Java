class SortedLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert an element while maintaining the sorted order
    public void insertSorted(int value) {
        Node newNode = new Node(value);

        // If list is empty or new node should be first
        if (head == null || head.data >= value) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse to find the correct insertion point
        Node current = head;
        while (current.next != null && current.next.data < value) {
            current = current.next;
        }

        // Insert new node at the correct position
        newNode.next = current.next;
        current.next = newNode;
    }

    // Print the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insertSorted(10);
        list.insertSorted(5);
        list.insertSorted(20);
        list.insertSorted(15);

        list.display(); // Output: 5 -> 10 -> 15 -> 20 -> null
    }
}
