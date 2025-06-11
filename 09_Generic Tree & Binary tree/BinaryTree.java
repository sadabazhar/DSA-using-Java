import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Scanner in = new Scanner(System.in); // define once and reuse

    public static Node insert() {
        System.out.print("Enter data (-1 for null): ");
        int data = in.nextInt();

        if (data == -1) {
            //No further nodes
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = insert();

        System.out.println("Enter right child of " + data);
        root.right = insert();

        return root;
    }

    //NLR (Visit root Node, then Left, then Right)
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //LNR (Visit left, then root node, then Right)
    public static void inOrder(Node root) {
        if (root == null) return;
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    //LRN (Visit left, then Right, then root node)
    public static void postOrder(Node root) {
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {

        Queue<Node> q = new ArrayDeque<>();
        Node marker = new Node(-1); // special marker

        // 1. Add root and marker to mark the end of the first level
        q.offer(root);
        q.offer(marker);

        // 2. Run loop until only one marker remains
        while (q.size() > 1) {
            Node front = q.poll();  // Get and remove front

            if (front == marker) {
                // 3. Level finished, print newline and add null for next level
                System.out.println();
                q.offer(marker);
            } else {
                // 4. Print current node and add its children if they exist
                System.out.print(front.data + " ");

                if (front.left != null) {
                    q.offer(front.left);
                }
                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Node root = insert();

        System.out.println("\n Preorder Traversal:");
        preOrder(root);

        System.out.println("\n Inorder Traversal:");
        inOrder(root);

        System.out.println("\n Postorder Traversal:");
        postOrder(root);

        System.out.println("\n Levelorder Traversal:");
        levelOrder(root);

        in.close(); // close only once at the end
    }
}
