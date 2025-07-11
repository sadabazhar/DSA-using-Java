import java.util.ArrayList;
import java.util.Arrays;

public class BSTfromInorder extends BinarySearchTree {

    // Create BST from sorted inorder list (balanced BST)
    public static TreeNode createBSTfromInorder(ArrayList<Integer> inorderList, int start, int end) {
        
        if (start > end) return null;

        // Find middle element 
        int mid = (start + end) / 2;
        int element = inorderList.get(mid);

        // Create the root node with middle element
        TreeNode root = new TreeNode(element);

        // Recursively build left and right subtrees
        root.left = createBSTfromInorder(inorderList, start, mid - 1);
        root.right = createBSTfromInorder(inorderList, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {

        // Sorted inorder list (ascending order is required)
        ArrayList<Integer> inorderList = new ArrayList<>(Arrays.asList(18, 19, 20, 21, 22));

        // Build BST
        TreeNode root = createBSTfromInorder(inorderList, 0, inorderList.size() - 1);

        // Print the tree in level order
        // levelOrderTraversal(root);
        preOrderTraversal(root);
    }
}
