import java.util.Arrays;

public class ConvertBSTintoDoublyLL extends BinarySearchTree {

    static TreeNode head = null;  // Will point to head of DLL
    static TreeNode prev = null;  // Will track the previous node in DLL

    // Inorder traversal (Left -> Root -> Right)
    public static void convertBSTintoDLL(TreeNode root) {
        if (root == null) return;

        // Left subtree
        convertBSTintoDLL(root.left);

        // Convert current node

        if (prev == null) head = root; // First node = head

        else {
            // Link previous and current node
            prev.right = root;
            root.left = prev;
        }

        // Move prev forward
        prev = root;

        // Right subtree
        convertBSTintoDLL(root.right);
    }

    public static void printList(TreeNode head) {
        if (head == null) return;

        TreeNode temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBSTFromList(Arrays.asList(5, 2, 6, 1, 3, 7));

        convertBSTintoDLL(root);
        printList(head);
    }
}
