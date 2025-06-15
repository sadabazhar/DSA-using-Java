/*
 * Balanced Binary Tree - A tree where every node has left and right subtree height difference <= 1
 * 
 * Naive Approach:
 * 1. Recursively calculate the height of left and right subtree
 * 2. Check if height difference is ≤ 1
 * 3. Recursively check if left and right subtrees are also balanced
 */

public class BalanceBT extends BinaryTree {

    // Compute the height of a tree
    public static int maxHeight(Node root){
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to check if a tree is balanced
    public static boolean isBalanced(Node root){
        if (root == null) return true; // Base case: null tree is balanced

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        int diff = Math.abs(leftHeight - rightHeight);

        // Check current node and it's child nodes
        if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = insert();

        if (isBalanced(root))
            System.out.println("It's a Balanced Binary Tree");
        else
            System.out.println("It's NOT a Balanced Binary Tree");
    }
}
