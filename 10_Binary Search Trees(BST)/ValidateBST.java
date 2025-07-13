/*
 * Problem: Check whether a Binary Tree is a valid Binary Search Tree (BST)
 */

import java.util.Arrays;

public class ValidateBST extends BinarySearchTree {

    public static boolean isValidBST(int min, TreeNode root, int max) {
        // Base case: An empty tree is a valid BST
        if (root == null) return true;

        // Check if current node violates the min/max constraints
        boolean minCheck = root.data > min;
        boolean maxCheck = root.data < max;

        // Recurse for left and right subtrees with updated ranges
        boolean leftAns = isValidBST(min, root.left, root.data);
        boolean rightAns = isValidBST(root.data, root.right, max);

        // Return true only if all conditions are satisfied
        return (minCheck && maxCheck && leftAns && rightAns);
    }

    public static void main(String args[]) {
        TreeNode root = createBSTFromList(Arrays.asList(20, 19, 22, 25, 28, 18));

        boolean isValid = isValidBST(Integer.MIN_VALUE, root, Integer.MAX_VALUE);

        if (isValid) System.out.println("It's a valid BST");
        else System.out.println("It's not a valid BST");
    }
}
