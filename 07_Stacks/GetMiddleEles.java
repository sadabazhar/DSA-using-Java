/*
 * Approach:
 * 1. getElementAt(pos):
 *    - Edge case:
 *      a. If position is less than 1 or greater than top + 1, throw an exception
 *    - Base case:
 *      a. If (pos - 1 == top), we have reached the desired position from the top
 *      b. Return the current top element
 *    - Recursive step:
 *      a. Save the top element
 *      b. Pop it
 *      c. Recursively call getElementAt(pos)
 *      d. Push the saved element back (restore stack)
 *      e. Return the result found
 */


public class GetMiddleEles extends StackDS {

    GetMiddleEles() {
        super();
    }

    GetMiddleEles(int size) {
        super(size);
    }

    public int getElementAt(int pos) {

        if (pos < 1 || pos > top + 1) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        // Base case
        if (pos-1 == top) return getTop();

        // Save and remove top element
        int data = getTop();
        pop();

        int result = getElementAt(pos);
        push(data);  // Restore the stack (backtracking)

        return result;
    }

    public static void main(String[] args) {
        GetMiddleEles st = new GetMiddleEles(5);

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.print();

        System.out.println("Element: " + st.getElementAt(1));
        st.print();
    }
}
