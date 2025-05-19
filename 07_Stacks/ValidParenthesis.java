/*
 * Approach:
 * 1. Return false if input string is empty
 * 2. Use a stack to store opening brackets
 * 3. Loop through string:
 *    - If opening bracket → push to stack
 *    - If closing bracket → check top of stack with current index:
 *        - If pair matched → pop
 *        - Else → return false
 * 4. After loop, if stack is empty → return true
 */


import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public static boolean checkValidParenthesis(String s) {

        if (s.isEmpty()) return false;      //Edge Case

        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {

                // If stack is empty and we find a closing bracket, it's invalid
                if (st.isEmpty()) return false;

                char top = st.peek(); // get top

                // Check for matching pair
                if ((top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')) {

                    st.pop(); // Pop matching opening bracket
                } else {
                    return false; // Mismatched pair
                }
            }
        }

        // If stack is empty, all brackets matched correctly
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}([]";

        System.out.println(checkValidParenthesis(s));
    }
}
