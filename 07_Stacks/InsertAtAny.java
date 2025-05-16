/*
 * Approach:
 * 1. insertAt(data, pos):
 *    - Edge case:
 *      a. If position is less than 1 or greater than top + 1, throw an exception
 *    - Base case:
 *      a. If position - 1 == top, it means we reached the target position
 *      b. Save the top element
 *      c. Pop it
 *      d. Push the new data
 *      e. Push the saved element back
 *    - Recursive step:
 *      a. Save the current top element
 *      b. Pop it
 *      c. Recursively call insertAt for the same position
 *      d. Push the saved element back (restore stack)
 */

public class InsertAtAny extends StackDS {
    InsertAtAny(){super();}
    InsertAtAny(int size){super(size);}

    public void insertAt(int data, int pos){
        //Egde case
        if (pos < 1 || pos > top + 1) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        //Insert at correct position
        if (pos-1 == top ) {
            int ele = getTop();
            pop();
            push(data);
            push(ele);
            return;
        }

        //Save and remove top element
        int stEle = getTop();
        pop();

        insertAt(data, pos);

        //Restore the poped element (backtrack)
        push(stEle);    
    }
    public static void main(String[] args) {
        InsertAtAny st = new InsertAtAny();

        st.push(10);
        st.push(20);
        st.push(40);

        st.insertAt(30, 1);
        st.print();
    }
}
