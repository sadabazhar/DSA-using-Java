import java.util.ArrayList;
import java.util.List;


public class PathSum2 extends BinaryTree{
    
    public static void pathSum(Node root, int targetSum, int sum, List<List<Integer>> finalList, List<Integer> tempList) {

        // If current node is null, just return
        if (root == null) return;

        // Add current node's dataue to the running sum and path
        sum += root.data;
        tempList.add(root.data);

        // If it's a leaf node and the path sum matches, add a copy of path to final result
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                finalList.add(new ArrayList<>(tempList));
            }
        } else {
            // Recur for left and right children
            pathSum(root.left, targetSum, sum, finalList, tempList);
            pathSum(root.right, targetSum, sum, finalList, tempList);
        }

        // Backtrack: remove the current node's dataue before returning to previous state
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {

        Node root = insert();

        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        pathSum(root, 20, 0, finalList, tempList);
    }

}
