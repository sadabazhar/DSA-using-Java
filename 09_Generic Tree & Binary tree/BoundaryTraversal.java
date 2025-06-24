import java.util.ArrayList;
import java.util.List;

/**
 * Approach: Boundary Traversal of a Binary Tree
 *
 * Goal:
 * Print all boundary nodes of a binary tree in anti-clockwise order.
 * The boundary includes:
 *  1. Left Boundary (excluding leaf nodes)
 *  2. All Leaf Nodes (from left to right)
 *  3. Right Boundary (excluding leaf nodes, in reverse)
 *
 * Steps:
 * 1. Start with the root node.
 * 2. Traverse down the left boundary (excluding leaf nodes).
 * 3. Traverse all leaf nodes from left to right.
 * 4. Traverse the right boundary (excluding leaf nodes), collect nodes, then reverse them.
 * 5. Combine all three parts to form the final boundary traversal.
 */

public class BoundaryTraversal extends BinaryTree {

    // Traverse left boundary (excluding leaves)
    public static List<Integer> leftBoundary(Node root, List<Integer> leftNodes) {
        if (root == null) return leftNodes;

        if (root.left == null && root.right == null) return leftNodes; // Ignore leaf

        leftNodes.add(root.data); // Add current node

        if (root.left != null)
            leftBoundary(root.left, leftNodes);
        else
            leftBoundary(root.right, leftNodes);

        return leftNodes;
    }

    // Traverse all leaf nodes (from left to right)
    public static List<Integer> leafBoundary(Node root, List<Integer> leafNodes) {
        if (root == null) return leafNodes;

        if (root.left == null && root.right == null) {
            leafNodes.add(root.data); // Add leaf node
            return leafNodes;
        }

        // Recur for both left and right subtrees
        leafBoundary(root.left, leafNodes);
        leafBoundary(root.right, leafNodes);

        return leafNodes;
    }

    // Traverse right boundary (excluding leaves) in bottom-up order
    public static List<Integer> rightBoundary(Node root, List<Integer> rightNodes) {
        if (root == null) return rightNodes;

        if (root.left == null && root.right == null) return rightNodes; // Ignore leaf

        if (root.right != null)
            rightBoundary(root.right, rightNodes);
        else
            rightBoundary(root.left, rightNodes);

        rightNodes.add(root.data); // Add after recursive call for bottom-up order

        return rightNodes;
    }

    // Combine all boundary parts
    public static void boundaryTraversal(Node root) {
        if (root == null) return;

        List<Integer> boundaryNodes = new ArrayList<>();

        boundaryNodes.add(root.data); // Root is always part of boundary

        // Add left boundary (excluding root and leaves)
        leftBoundary(root.left, boundaryNodes);

        // Add all leaf nodes
        leafBoundary(root.left, boundaryNodes);
        leafBoundary(root.right, boundaryNodes);

        // Add right boundary in reverse (excluding root and leaves)
        List<Integer> rightNodes = new ArrayList<>();
        rightBoundary(root.right, rightNodes);
        boundaryNodes.addAll(rightNodes);

        System.out.println("Boundary Traversal: " + boundaryNodes);
    }

    public static void main(String[] args) {
        Node root = insert();
        boundaryTraversal(root);
    }
}
