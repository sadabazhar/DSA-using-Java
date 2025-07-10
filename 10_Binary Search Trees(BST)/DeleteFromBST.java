import java.util.Arrays;

public class DeleteFromBST extends BinarySearchTree {

    // Find the node with the minimum value (used for replacing in two-child case)
    public static TreeNode findMinNode(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    // Delete a node from BST and return the updated root
    public static TreeNode deleteTreeNode(TreeNode root, int target) {
        if (root == null) return null;

        // Search for the target node
        if (target < root.data) {
            root.left = deleteTreeNode(root.left, target); // go left
        } else if (target > root.data) {
            root.right = deleteTreeNode(root.right, target); // go right
        } else {
            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child (only right)
            else if (root.left == null) {
                return root.right;
            }

            // Case 3: One child (only left)
            else if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            else {
                TreeNode minNode = findMinNode(root.right); // smallest in right subtree
                root.data = minNode.data; // copy value
                root.right = deleteTreeNode(root.right, minNode.data); // delete copied node
            }
        }

        return root; // return updated root
    }

    public static void main(String[] args) {
        TreeNode root = createBSTFromList(Arrays.asList(20, 19, 22, 18, 21));

        System.out.println("Before deletion:");
        levelOrderTraversal(root);
        System.out.println();

        root = deleteTreeNode(root, 20);

        System.out.println("After deletion:");
        levelOrderTraversal(root);
    }
}
