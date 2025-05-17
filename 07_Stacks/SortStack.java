/*
 * Approach:
 * 1. sortStack():
 *    - Base case: If stack is empty, return
 *    - Otherwise:
 *      a. Save the top element
 *      b. Remove the top element
 *      c. Recursively sort the remaining stack by
 *      d. Insert the saved element at its correct position by calling insertAtSortedStack(data)
 * 
 * 2. insertAtSortedStack(data):
 *    - Base case:
 *      a. If stack is empty or data >= top element, push it
 *    - Otherwise:
 *      a. Save the top element
 *      b. Remove the top element
 *      c. Recursively insert 'data'
 *      d. Push back the saved element (backtracking)
 */


public class SortStack extends StackDS {
    SortStack(){super();}
    SortStack(int size){super(size);}

    public void insertAtSortedStack(int data){
        //base case
        if (top == -1 || data >= getTop()) {
            push(data);
            return;
        }

        int element = getTop();
        pop();

        insertAtSortedStack(data);
        push(element);
    }

    public void sortStack(){
        //base case
        if (top == -1) {
            return;
        }

        int element = getTop();
        pop();

        sortStack();
        insertAtSortedStack(element);
    }

    public static void main(String[] args) {
        SortStack st = new SortStack(5);

        st.push(10);
        st.push(30);
        st.push(25);
        st.push(15);
        // st.insertAtSortedStack(25);

        st.sortStack();

        st.print();
    }
}
