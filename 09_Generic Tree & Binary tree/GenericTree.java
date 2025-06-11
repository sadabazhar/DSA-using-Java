import java.util.*;

public class GenericTree {

    public static class Node {
        int data;
        List<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    static Scanner in = new Scanner(System.in);

    public static Node insert() {
        System.out.print("Enter data: ");
        int data = in.nextInt();

        if (data == -1) {
            //No further nodes
            return null;
        }

        Node node = new Node(data);

        System.out.print("Enter number of children for " + data + ": ");
        int childCount = in.nextInt();

        for (int i = 0; i < childCount; i++) {
            System.out.println("Enter child " + (i + 1) + " of " + data);
            node.children.add(insert());
        }

        return node;
    }

    public static void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        for (Node child : node.children) {
            preOrder(child);
        }
    }

    public static void main(String[] args) {

        Node root = insert();

        System.out.println("Preorder Traversal:");
        preOrder(root);

        in.close();
    }
}
