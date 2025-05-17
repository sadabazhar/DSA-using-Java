/*
 * Approach:
 * 1. reverseStack():
 *    - Base case: If stack is empty, return
 *    - Otherwise:
 *      a. Save the top element
 *      b. Pop the top element
 *      c. Recursively reverse the remaining stack by
 *      d. Insert the saved element at the bottom by calling insertAtBottom(data)

 * 2. insertAtBottom(data):
 *    - Base case:
 *      a. If stack is empty (top == -1), push the data
 *    - Otherwise:
 *      a. Save the top element
 *      b. Pop the top element
 *      c. Recursively insert the new data at the bottom
 *      d. Push the saved element back (restore stack)
 */


public class ReverseStack extends StackDS {
    ReverseStack(){super();}
    ReverseStack(int size){super(size);}

    public void insertAtBottom(int data){

        //base case
        if (top == -1) {     //top == 0 means we stand at bottom of stack   
            push(data);
            return;
        }

        //Save and remove top element
        int element = getTop();
        pop();

        insertAtBottom(data);

        //Restore the stack
        push(element);
    }

    public void reverseStack(){
        //base case
        if (top == -1) {
            return;
        }

        //Save and remove top element
        int element = getTop();
        pop();

        reverseStack();

        //insert at bottom
        insertAtBottom(element);
    }

    public static void main(String[] args) {
        ReverseStack st = new ReverseStack(5);

        st.push(10);
        st.push(20);
        st.push(30);

        st.insertAtBottom(11);
        st.reverseStack();

        st.print();
    }
}
