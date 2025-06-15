/*
 * Problem: Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 
 * Approach: 

    1. Start at the root node.

    2. Keep adding the current node's value to a running sum.

    3. If we reach a leaf node (both children are null), check if the sum equals targetSum.

    - If yes, return true.

    4. If not a leaf, recursively check the left and right subtrees.

    5. If any path returns true, propagate that up.
 */

public class PathSum extends BinaryTree {

    public static boolean pathSum(Node root, int targetSum, int sum) {

        // Base case: if current node is null, no path exists
        if (root == null) return false;

        // Add current node's value to the path sum
        sum += root.data;

        // If we're at a leaf node, check if the path sum equals targetSum
        if (root.left == null && root.right == null) {
            return sum == targetSum; // true if sum matches, false otherwise
        }

        // Recurse into left and right subtrees
        boolean leftAns = pathSum(root.left, targetSum, sum);
        boolean rightAns = pathSum(root.right, targetSum, sum);

        // Return true if either left or right path has the required sum
        return leftAns || rightAns;
    }

    public static void main(String[] args) {
        Node root = insert();

        if (pathSum(root, 30, 0))
            System.out.println("PAth exists");
        else
            System.out.println("Path doesn't exists");
    }
}
