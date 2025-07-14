import java.util.Arrays;

public class KthSmallestNode extends BinarySearchTree {

    static int count = 0;
    static int result = -1;

    public static int findKthSmallestNode(TreeNode root, int k) {
        if (root == null) return result;

        // Traverse left subtree
        findKthSmallestNode(root.left, k);

        // Visit node
        count++;
        if (count == k) {
            result = root.data;
            return result; // Stop
        }

        // Traverse right subtree
        findKthSmallestNode(root.right, k);
        
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = createBSTFromList(Arrays.asList(21, 19, 23, 17, 20, 22));
        
        int k = 6;
        result = findKthSmallestNode(root, k);

        if (result != -1) 
            System.out.println(k + "th smallest node is: " + result);
        else 
            System.out.println("Tree is empty or Invalid selection");
    }
}
