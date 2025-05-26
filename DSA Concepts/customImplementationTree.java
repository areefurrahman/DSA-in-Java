public class customImplementationTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class Tree {

        Node insertion(Node root, int key) {

            if (root == null) {
                root = new Node(key);
                return root;

            } else if (key < root.data) {

                root.left = insertion(root.left, key);
            } else {
                root.right = insertion(root.right, key);
            }
            return root;
        }

        boolean searchNode(Node root, int key) {
            if (root == null) {
                return false;

            } else if (root.data == key) {
                return true;

            } else if (key > root.data) {
                return searchNode(root.right, key);
            } else
                return searchNode(root.left, key);
        }

        void preorder(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        void inorder(Node root) {
            if (root != null) {

                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }

        void postorder(Node root) {
            if (root != null) {

                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        customImplementationTree treeObj = new customImplementationTree();
        Tree tree = treeObj.new Tree();

        Node root = null;
        int[] values = {6, 9, 3, 11, 7, 8, 2, 4};

        for (int value : values) {
            root = tree.insertion(root, value);
        }

        System.out.print("Preorder: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(root);
        System.out.println();
    }

}
