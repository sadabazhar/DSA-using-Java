import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Views extends BinaryTree {

    // Left View: Show the first node seen from the left at each level
    public static void leftView(Node root, int level, ArrayList<Integer> leftViewList) {
        if (root == null) return;

        // If we're visiting this level for the first time, add this node
        if (level == leftViewList.size()) {
            leftViewList.add(root.data);
        }

        // Go to left child first
        leftView(root.left, level + 1, leftViewList);

        // Then right child
        leftView(root.right, level + 1, leftViewList);
    }

    // Right View: Show the first node seen from the right at each level
    public static void rightView(Node root, int level, ArrayList<Integer> rightViewList) {
        if (root == null) return;

        // If we're visiting this level for the first time, add this node
        if (level == rightViewList.size()) {
            rightViewList.add(root.data);
        }

        // Go to right child first
        rightView(root.right, level + 1, rightViewList);

        // Then left child
        rightView(root.left, level + 1, rightViewList);
    }

    // Top View: Show the top-most nodes from left to right
    public static void topView(Node root, int level, ArrayList<Integer> topViewList) {
        if (root == null) return;

        Map<Integer, Integer> map = new TreeMap<>(); // To store horizontal distance and node data
        Queue<Map.Entry<Node, Integer>> q = new LinkedList<>();

        // Start from root at horizontal distance 0
        q.offer(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            Map.Entry<Node, Integer> entry = q.poll();
            Node node = entry.getKey();
            int hd = entry.getValue();

            // Only add first node at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Move to left and right children with updated horizontal distance
            if (node.left != null) q.offer(new AbstractMap.SimpleEntry<>(node.left, hd - 1));
            if (node.right != null) q.offer(new AbstractMap.SimpleEntry<>(node.right, hd + 1));
        }

        // Collect top view nodes in order
        for (int val : map.values()) {
            topViewList.add(val);
        }
    }

    // Bottom View: Show the bottom-most nodes from left to right
    public static void bottomView(Node root, int level, ArrayList<Integer> bottomViewList) {
        if (root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Map.Entry<Node, Integer>> q = new LinkedList<>();

        q.offer(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            Map.Entry<Node, Integer> entry = q.poll();
            Node node = entry.getKey();
            int hd = entry.getValue();

            // Always update the node at current horizontal distance
            map.put(hd, node.data);

            if (node.left != null) q.offer(new AbstractMap.SimpleEntry<>(node.left, hd - 1));
            if (node.right != null) q.offer(new AbstractMap.SimpleEntry<>(node.right, hd + 1));
        }

        // Collect bottom view nodes in order
        for (int val : map.values()) {
            bottomViewList.add(val);
        }
    }

    public static void main(String[] args) {
        Node root = insert();

        ArrayList<Integer> leftViewList = new ArrayList<>();
        ArrayList<Integer> rightViewList = new ArrayList<>();
        ArrayList<Integer> topViewList = new ArrayList<>();
        ArrayList<Integer> bottomViewList = new ArrayList<>();

        leftView(root, 0, leftViewList);
        rightView(root, 0, rightViewList);
        topView(root, 0, topViewList);
        bottomView(root, 0, bottomViewList);

        System.out.println("Left View: " + leftViewList);
        System.out.println("Right View: " + rightViewList);
        System.out.println("Top View: " + topViewList);
        System.out.println("Bottom View: " + bottomViewList);
    }
}
