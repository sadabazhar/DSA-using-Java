import java.util.ArrayList;
import java.util.List;

/*
 * Problem statement: 
 *  You are given the root of a binary tree and an integer targetSum.
 *  You need to find all root-to-leaf paths in the tree where the sum of all the node values in the path is equal to targetSum.
 *  Return those paths as a list of lists.

 * Approach:

    1. Use DFS (Depth First Search) to go through the tree.

    2. Maintain:

        - a sum to store the sum of values in that path,

        - a tempList to store the current path

    3. When we reach a leaf node, we:

        - Check if the sum equals the targetSum.

        - If yes, add a copy of that path to the final answer.

    4. Use backtracking to remove the last node when we go back up — this avoids using the same list for different paths.


*/

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
