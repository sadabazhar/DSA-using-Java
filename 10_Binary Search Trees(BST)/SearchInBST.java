import java.util.Arrays;

public class SearchInBST extends BinarySearchTree {

    public static boolean seachNode(TreeNode root, int target) {

        // If the current node is null, target doesn't exist
        if (root == null) return false;

        // If target matches the current node's value, return true
        if (root.data == target) return true;

        boolean rightAns = false;
        boolean leftAns = false;

        // If target is greater than current node, search in the right subtree
        if (target > root.data) rightAns = seachNode(root.right, target);

        // If target is smaller than current node, search in the left subtree
        else leftAns = seachNode(root.left, target);

        // Return true if found in either left or right subtree
        return rightAns || leftAns;
    }

    public static void main(String[] args) {
        TreeNode root = createBSTFromList(Arrays.asList(20, 19, 22, 18, 21));

        if (seachNode(root, 21))
            System.out.println("Target Found");
        else
            System.out.println("Not available");
    }
}
