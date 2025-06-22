import java.util.Deque;
import java.util.ArrayDeque;

public class DequeExample {
    public static void main(String[] args) {

        // Create a deque of integers
        Deque<Integer> deque = new ArrayDeque<>();

        // Add elements at the end (rear)
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println("After addLast(): " + deque);

        // Add elements at the front
        deque.addFirst(5);
        deque.addFirst(1);
        System.out.println("After addFirst(): " + deque);

        // Peek elements (don't remove, just see)
        System.out.println("First element (peekFirst()): " + deque.peekFirst());
        System.out.println("Last element (peekLast()): " + deque.peekLast());

        // Remove elements from front and back
        int removedFront = deque.removeFirst();
        int removedBack = deque.removeLast();
        System.out.println("Removed from front: " + removedFront);
        System.out.println("Removed from back: " + removedBack);
        System.out.println("Deque after removals: " + deque);

        // Check if deque contains an element
        System.out.println("Does deque contain 20? " + deque.contains(20));

        // Size of deque
        System.out.println("Size of deque: " + deque.size());

        // Iterate through deque
        System.out.println("Elements in deque:");
        for (int num : deque) {
            System.out.println(num);
        }
    }
}
