class ActionNode {
    String action; 
    String product;
    ActionNode prev;
    ActionNode next;

    public ActionNode(String action, String product) {
        this.action = action;
        this.product = product;
        this.prev = null;
        this.next = null;
    }
}

class ShoppingCart {
    ActionNode head;
    ActionNode tail;
    ActionNode current;

    public void addProduct(String product) {
        ActionNode newNode = new ActionNode("add", product);

        if (current != tail && tail != null) {
            ActionNode temp = current.next;
            while (temp != null) {
                ActionNode next = temp.next;
                temp = next;
            }
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
        }
        System.out.println("Added: " + product);
    }

    public void undo() {
        if (current != null) {
            System.out.println("Undo: " + current.action + " " + current.product);
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.action + " " + current.product);
        } else if (current == null && head != null) {
            current = head;
            System.out.println("Redo: " + current.action + " " + current.product);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void removeProduct(String product) {
        ActionNode newNode = new ActionNode("remove", product);

        // Clear redo history
        if (current != tail && tail != null) {
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
        }
        System.out.println("Removed: " + product);
    }

    public void displayCart() {
        System.out.println("Cart contents:");
        ActionNode temp = head;
        java.util.ArrayList<String> cart = new java.util.ArrayList<>();
        while (temp != null) {
            if (temp == current.next) break; 
            if (temp.action.equals("add")) {
                cart.add(temp.product);
            } else if (temp.action.equals("remove")) {
                cart.remove(temp.product);
            }
            temp = temp.next;
        }

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (String item : cart) {
                System.out.println("- " + item);
            }
        }
    }

    public void searchHistory(String product) {
        ActionNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.product.equals(product)) {
                System.out.println("Found in history: " + temp.action + " " + product);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Product not found in history.");
        }
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple");
        cart.addProduct("Banana");
        cart.removeProduct("Apple");

        cart.displayCart(); 

        cart.undo(); 
        cart.displayCart(); 

        cart.undo(); 
        cart.displayCart(); 

        cart.redo(); 
        cart.displayCart(); 

        cart.searchHistory("Apple");
        cart.searchHistory("Orange");
    }
}
