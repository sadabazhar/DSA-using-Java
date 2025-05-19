/*
 * 📌 Problem: Design a Stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * ✅ Algorithm:
 * - Use two stacks:
 *   1. `stack`     → stores all actual values
 *   2. `minStack`  → stores the minimum value corresponding to each element in `stack`
 *
 * - When pushing a new value:
 *   - Push it to `stack`
 *   - If `minStack` is empty or the new value is smaller than or equal to the current minimum,
 *     push it to `minStack`
 *   - Otherwise, push the current top of `minStack` again (to maintain size alignment)
 *
 * - When popping:
 *   - Pop from both `stack` and `minStack`
 *
 * - The top of `minStack` always gives the current minimum value in the `stack`
 *
 * ✅ Time Complexity:
 * - push(), pop(), top(), getMin() → O(1)
 *
 * ✅ Space Complexity:
 * - O(n) → for maintaining the two stacks
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    // Stack to store actual elements
    private Deque<Integer> stack;

    // Stack to store minimum value at each level of the stack
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    // Pushes the value onto the main stack and updates minStack
    public void push(int val) {
        stack.push(val);

        // Push value to minStack if it's the new minimum, else repeat the previous min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // Removes the top element from both stacks
    public void pop() {
        if (stack.isEmpty()) {
            System.err.println("Stack Underflow!");
            return;
        }
        stack.pop();
        minStack.pop();
    }

    // Returns the top element of the main stack
    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");
        return stack.peek();
    }

    // Returns the minimum element in constant time
    public int getMin() {
        if (minStack.isEmpty()) throw new RuntimeException("Stack is empty!");
        return minStack.peek();
    }

    // Utility method to print both stacks
    public void printStack() {
        System.out.println("Stack: " + stack);
        System.out.println("Min Stack: " + minStack);
    }

    // Main method for testing the MinStack functionality
    public static void main(String[] args) {
        MinStack st = new MinStack();

        st.push(4);
        st.push(2);
        st.push(5);
        st.push(1);
        st.printStack();

        System.out.println("Min: " + st.getMin()); // 1
        st.pop(); // remove 1
        System.out.println("Min after pop: " + st.getMin()); // 2
    }
}
