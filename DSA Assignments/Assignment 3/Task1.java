class Learner {
    int id;
    double marks;
    Learner leftChild, rightChild;

    public Learner(int id, double marks) {
        this.id = id;
        this.marks = marks;
        leftChild = null;
        rightChild = null;
    }

    @Override
    public String toString() {
        return " -------------------------\n" +
               " >> Roll No: " + id + "\n >> Score: " + marks;
    }
}

class MarksTree {
    public Learner rootNode;

    public Learner addLearner(Learner current, int id, double marks) {
        if (current == null) {
            System.out.println("Learner with ID (" + id + ") added!");
            return new Learner(id, marks);
        } else if (id < current.id) {
            current.leftChild = addLearner(current.leftChild, id, marks);
        } else if (id > current.id) {
            current.rightChild = addLearner(current.rightChild, id, marks);
        } else {
            System.out.println("Warning: Learner with ID " + id + " already exists!");
        }
        return current;
    }

    public boolean findLearner(Learner current, int id) {
        if (current == null) {
            System.out.println("Learner not found.");
            return false;
        }
        if (id == current.id) {
            System.out.println("Learner located!\nDetails:\n" + current);
            return true;
        } else if (id < current.id) {
            return findLearner(current.leftChild, id);
        } else {
            return findLearner(current.rightChild, id);
        }
    }

    public void printLearners(Learner current) {
        if (current != null) {
            printLearners(current.leftChild);
            System.out.println(current);
            printLearners(current.rightChild);
        }
    }

    public Learner getMinScoreLearner(Learner current) {
        if (current == null) return null;

        Learner min = current;
        Learner leftMin = getMinScoreLearner(current.leftChild);
        Learner rightMin = getMinScoreLearner(current.rightChild);

        if (leftMin != null && leftMin.marks < min.marks) {
            min = leftMin;
        }
        if (rightMin != null && rightMin.marks < min.marks) {
            min = rightMin;
        }

        return min;
    }

    public Learner getMaxScoreLearner(Learner current) {
        if (current == null) return null;

        Learner max = current;
        Learner leftMax = getMaxScoreLearner(current.leftChild);
        Learner rightMax = getMaxScoreLearner(current.rightChild);

        if (leftMax != null && leftMax.marks > max.marks) {
            max = leftMax;
        }
        if (rightMax != null && rightMax.marks > max.marks) {
            max = rightMax;
        }

        return max;
    }
}

public class Task1 {
    public static void main(String[] args) {
        MarksTree tree = new MarksTree();

        tree.rootNode = tree.addLearner(tree.rootNode, 1, 11);
        tree.rootNode = tree.addLearner(tree.rootNode, 2, 9);
        tree.rootNode = tree.addLearner(tree.rootNode, 5, 13);
        tree.rootNode = tree.addLearner(tree.rootNode, 4, 29);
        tree.rootNode = tree.addLearner(tree.rootNode, 3, 22);

        System.out.println("\nChecking duplicate entry:");
        tree.rootNode = tree.addLearner(tree.rootNode, 5, 14); // Duplicate ID

        System.out.println("\nLooking for learner with ID 3:");
        tree.findLearner(tree.rootNode, 3);

        System.out.println("\nList of all learners (sorted):");
        tree.printLearners(tree.rootNode);

        System.out.println("\n!! Learner with the lowest marks:");
        System.out.println(tree.getMinScoreLearner(tree.rootNode));

        System.out.println("\n!! Learner with the highest marks:");
        System.out.println(tree.getMaxScoreLearner(tree.rootNode));
    }
}
