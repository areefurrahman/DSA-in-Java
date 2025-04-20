// Node class for Linked List
class ActionNode {
    String action;
    ActionNode next;

    public ActionNode(String action) {
        this.action = action;
        this.next = null;
    }
}

// Stack implementation using Linked List
class ActionStack {
    private ActionNode top;

    // Push new action to the stack
    public void push(String action) {
        ActionNode newNode = new ActionNode(action);
        newNode.next = top;
        top = newNode;
        System.out.println("Action pushed: " + action);
    }

    // Undo last action (pop from the stack)
    public String pop() {
        if (top == null) {
            System.out.println("No actions to undo.");
            return null;
        }
        String action = top.action;
        top = top.next;
        System.out.println("Action undone: " + action);
        return action;
    }

    // Peek at current state
    public String peek() {
        if (top == null) {
            System.out.println("No actions available.");
            return null;
        }
        System.out.println("Current action: " + top.action);
        return top.action;
    }

    // Display all actions
    public void display() {
        if (top == null) {
            System.out.println("No actions to display.");
            return;
        }
        System.out.println("All actions in stack:");
        ActionNode current = top;
        while (current != null) {
            System.out.println("- " + current.action);
            current = current.next;
        }
    }
}

// Testing the stack
public class StackTextEditorUndoRedo {
    public static void main(String[] args) {
        ActionStack stack = new ActionStack();

        stack.push("Insert 'Hello'");
        stack.push("Insert 'World'");
        stack.push("Delete 'o'");
        stack.display();

        stack.peek();
        stack.pop();
        stack.peek();
        stack.display();
    }
}
