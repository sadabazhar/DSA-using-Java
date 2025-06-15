/*
 * Problem: Find Lowest Common Ancestor (LCA) in a Binary Tree
 * 
 * Approach:
 * 1. Start from the root and look for p and q in left and right subtrees.
 * 2. If one is found in the left and the other in the right, current node is the LCA.
 * 3. If both are in the same side, return the answer from that side.
 * 4. If the current node is either p or q, return it.
 */

public class LowestCommonAncestor extends BinaryTree {

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // Base case: if root is null or matches p or q
        if (root == null || root == p || root == q) return root;

        // Recursively find LCA in left and right subtrees
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a node, root is the LCA
        if (left != null && right != null) return root;

        // Otherwise, return the non-null result
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        Node root = insert();  // Use your existing insert() to build the tree

        // Example: manually finding two nodes (ensure the values exist in the tree)
        Node p = root.left;  // Replace with actual node you want as p
        Node q = root.right; // Replace with actual node you want as q

        Node lca = lowestCommonAncestor(root, p, q);
        if (lca != null)
            System.out.println("Lowest Common Ancestor is: " + lca.data);
        else
            System.out.println("Lowest Common Ancestor not found.");
    }
}