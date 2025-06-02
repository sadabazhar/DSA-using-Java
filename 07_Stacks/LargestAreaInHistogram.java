import java.util.*;

public class LargestAreaInHistogram {

    // Find index of the next smaller element for each bar
    public static ArrayList<Integer> findNextSmaller(ArrayList<Integer> nums) {
        int n = nums.size();
        ArrayList<Integer> next = new ArrayList<>(Collections.nCopies(n, n)); // All value set n
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums.get(st.peek()) >= nums.get(i)) {
                st.pop();
            }

            if (!st.isEmpty()) {
                next.set(i, st.peek());
            }

            st.push(i);
        }

        return next;
    }

    // Find index of the previous smaller element for each bar
    public static ArrayList<Integer> findPreSmaller(ArrayList<Integer> nums) {
        int n = nums.size();
        ArrayList<Integer> prev = new ArrayList<>(Collections.nCopies(n, -1)); // default -1
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums.get(st.peek()) >= nums.get(i)) {
                st.pop();
            }

            if (!st.isEmpty()) {
                prev.set(i, st.peek());
            }

            st.push(i);
        }

        return prev;
    }

    // Calculate the largest rectangle area in the histogram
    public static int largestArea(ArrayList<Integer> heights) {
        ArrayList<Integer> next = findNextSmaller(heights);
        ArrayList<Integer> prev = findPreSmaller(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.size(); i++) {
            int height = heights.get(i);
            int width = next.get(i) - prev.get(i) - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(2, 1, 5, 6,2, 3));

        System.out.println("Next Smaller Index: " + findNextSmaller(list));
        System.out.println("Previous Smaller Index: " + findPreSmaller(list));
        System.out.println("Largest Rectangle Area: " + largestArea(list));
    }
}
