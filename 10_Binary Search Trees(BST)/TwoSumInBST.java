/*
 * Problem Statement: Given the root of a binary search tree and an integer k, return true
 * if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumInBST extends BinarySearchTree {

    // This method checks if there exists a pair of numbers in the sorted list that adds up to 'k'
    public static boolean findTwoSum(ArrayList<Integer> sortedNodeList, int k) {

        if (sortedNodeList == null) return false;

        int start = 0, end = sortedNodeList.size() - 1;

        // Use two-pointer approach to find the pair
        while (start < end) {
            int sum = sortedNodeList.get(start) + sortedNodeList.get(end);

            if (sum < k) start++;           // If sum is too small, move start forward
            else if (sum > k) end--;        // If sum is too big, move end backward
            else return true;               // Found the target sum
        }

        return false;  // No such pair found
    }

    // This method stores the BST nodes in sorted order (in-order traversal)
    public static ArrayList<Integer> inOrderStore(TreeNode root, ArrayList<Integer> nodeList) {
        if (root == null) return nodeList;  // Fix: Should return nodeList, not null

        inOrderStore(root.left, nodeList);      // Visit left subtree
        nodeList.add(root.data);               // Visit current node
        inOrderStore(root.right, nodeList);     // Visit right subtree

        return nodeList;
    }

    public static void main(String[] args) {

        TreeNode root = createBSTFromList(Arrays.asList(5, 3, 6, 2, 4, 7));

        ArrayList<Integer> sortedNodeList = inOrderStore(root, new ArrayList<>());

        System.out.println("In-order Traversal: " + sortedNodeList);

        int target = 11;
        if (findTwoSum(sortedNodeList, target)) {
            System.out.println("Pair Found with sum = " + target);
        } else {
            System.out.println("No Pair Found with sum = " + target);
        }
    }
}

