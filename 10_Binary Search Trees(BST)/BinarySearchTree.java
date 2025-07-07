import java.util.*;

public class BinarySearchTree {

    // Node structure for the tree
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to insert data into BST
    public static TreeNode insertNode(TreeNode root, int data) {
        if (root == null) {
            // If tree is empty, create a new node
            return new TreeNode(data);
        }

        // If data is smaller, go left
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        }
        // If data is greater, go right
        else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root; // return updated tree
    }

    // Function to build BST from a list of values
    public static TreeNode createBSTFromList(List<Integer> values) {
        TreeNode root = null;

        for (int data : values) {
            if (data == -1) break; // -1 means stop
            root = insertNode(root, data);
        }

        return root;
    }

    public static void preOrderTraversal(TreeNode root){

        if(root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public static void inOrderTraversal(TreeNode root){

        if(root == null) return;

        preOrderTraversal(root.left);
        System.out.print(root.data + " ");
        preOrderTraversal(root.right);

    }

    public static void postOrderTraversal(TreeNode root){

        if(root == null) return;

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // null marks the end of one level

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                System.out.println(); // move to next line after a level
                if (!queue.isEmpty()) {
                    queue.offer(null); // mark next level
                }
            } else {
                System.out.print(current.data + " ");

                // Add child nodes to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        TreeNode root = createBSTFromList(Arrays.asList(22, 20, 21, 25, -1));

        System.out.print("Pre Order Traversal of BST:");
        preOrderTraversal(root);
        System.out.println();

        System.out.print("In Order Traversal of BST:");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("Post Order Traversal of BST:");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("Level Order Traversal of BST:");
        levelOrderTraversal(root);
    }
}
