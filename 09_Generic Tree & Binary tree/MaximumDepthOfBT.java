
public class MaximumDepthOfBT extends BinaryTree{
    
    public static int maxDepth(Node root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int height = Math.max(left, right) + 1;

        return height;
    }

    public static void main(String[] args) {
        Node root = insert();

        System.out.println("Heigth of tree: " + maxDepth(root));
    }
}
