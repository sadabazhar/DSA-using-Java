/*
 * 🔹 Problem: Next Smaller Element (NSE)
 * 
 * I/P: [8, 4, 6, 2, 3]         O/P: [4 , 2, 2, -1 , -1]
 * 
 * For every element in the array, find the next smaller element to its right.
 * If there is no smaller element, return -1 for that position.
 *
 * 🔹 Simple Algorithm:
 * 1. Traverse the array from right to left.
 * 2. Use a stack to keep track of potential "next smaller elements".
 * 3. For each element:
 *    - Remove all elements from the stack that are greater or equal.
 *    - The top of the stack (if any) is the next smaller element.
 *    - Push the current element to the stack.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NextSmallerElement {
    // To store the result
    protected ArrayList<Integer> ans = new ArrayList<>();
    
    // Stack to keep track of next smaller elements
    protected Deque<Integer> st = new ArrayDeque<>();

    public ArrayList<Integer> findNextSmaller(ArrayList<Integer> nums) {

        for (int i = nums.size() - 1; i >= 0; i--) {
            int curr = nums.get(i);

            // Remove elements from stack which are not smaller
            while (!st.isEmpty() && st.peek() >= curr) {
                st.pop();
            }

            // If stack is empty, no smaller element exists
            if (st.isEmpty()) {
                ans.add(0, -1);
            } else {
                ans.add(0, st.peek());
            }

            // Push current element to stack
            st.push(curr);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(8);
        nums.add(4);
        nums.add(6);
        nums.add(2);
        nums.add(3);

        NextSmallerElement obj = new NextSmallerElement();
        System.out.println(obj.findNextSmaller(nums));
    }
}
