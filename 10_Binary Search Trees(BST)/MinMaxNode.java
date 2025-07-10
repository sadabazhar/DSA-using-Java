import java.util.Arrays;

public class MinMaxNode extends BinarySearchTree{

    public static TreeNode findMiNode(TreeNode root) {

        if (root == null) return null;

        // Go to the leftmost node (smallest value in BST)
        TreeNode temp = root;
        while (temp.left != null) temp = temp.left;

        return temp;
    }

    public static TreeNode findMaxNode(TreeNode root) {

        if (root == null) return null;

        // Go to the rightmost node (largest value in BST)
        TreeNode temp = root;
        while (temp.right != null) temp = temp.right;

        return temp;
    }


    public static void main(String[] args) {

        TreeNode root = createBSTFromList(Arrays.asList(20, 19, 22, 25, 28, 18));

        System.out.println("Min Node of BST: " + findMiNode(root).data);   
        System.out.println("Max Node of BST: " + findMaxNode(root).data);   
    }
}
