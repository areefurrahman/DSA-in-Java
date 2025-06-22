import java.util.ArrayList;
import java.util.LinkedList;

public class arraylistConcept {
    public static void main(String[] args) {
        LinkedList<Integer> arr = new LinkedList<>();

        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println("Before adding " + arr);

        arr.set(1, 2);
        System.out.println(arr);
    }
}
