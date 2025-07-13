import java.util.Arrays;

public class LowestCommonAncestor extends BinarySearchTree {

    public static TreeNode findLCA(TreeNode root, int p, int q) {

        // Base case: Empty tree
        if (root == null) return null;

        // Case 1: if p and q are both smaller than root, go left
        if (p < root.data && q < root.data)
            return findLCA(root.left, p, q);

        // Case 2: if p and q are both greater than root, go right
        if (p > root.data && q > root.data)
            return findLCA(root.right, p, q);

        // Case 3: p and q are on different sides, root is LCA
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = createBSTFromList(Arrays.asList(21, 19, 23, 17, 20, 22));

        int p = 24, q = 22;
        TreeNode LCA = findLCA(root, p, q);
        
        if (LCA != null)
            System.out.println("Lowest Common Ancestor of " + p + " and " + q + " is: " + LCA.data);
        else
            System.out.println("No Lowest Common Ancestor exists");
    }
}
