import java.util.ArrayList;

public class TwoStack {

    int size;
    int top1;
    int top2;
    ArrayList<Integer> stack;

    TwoStack() {
        this(5);        //Defult size 5
    }

    TwoStack(int size) {
        this.size = size;
        top1 = -1;
        top2 = size;
        stack = new ArrayList<>(size);

        //Set all element with 0, bcz arraylist initialize with 0 size
        for (int i = 0; i < size; i++) {
            stack.add(0);
        }
    }

    public void pushStack1(int data) {
        // If top1 and top2 are adjacent means stack full
        if (top1 + 1 == top2) {
            System.err.println("Stack1 Overflow!");
            return;
        }

        top1++;
        stack.set(top1, data);
    }

    public void pushStack2(int data) {
        // If top1 and top2 are adjacent means stack full
        if (top1 + 1 == top2) {
            System.err.println("Stack2 Overflow!");
            return;
        }

        top2--;
        stack.set(top2, data);
    }

    public void popStack1() {
        if (top1 == -1) {
            System.err.println("Stack1 Underflow!");
            return;
        }

        stack.remove(top1);
        top1--;
    }

    public void popStack2() {
        if (top2 == size) {
            System.err.println("Stack2 Underflow!");
            return;
        }

        stack.remove(top2);
        top2++;
    }

    public void printStack1() {
        if (top1 == -1) {
            System.err.println("Stack1 is empty!");
            return;
        }

        for (int i = top1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public void printStack2() {
        if (top2 == size) {
            System.err.println("Stack2 is empty!");
            return;
        }

        for (int i = top2; i < size; i++) {
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
        TwoStack st = new TwoStack(8);

        st.pushStack1(10);
        st.pushStack1(20);
        st.pushStack1(30);
        
        st.pushStack2(10);
        st.pushStack2(20);
        st.pushStack2(30);
        
        System.out.println("Stack1");
        st.printStack1();
        System.out.println("Stack2");
        st.printStack2();
    }
}
