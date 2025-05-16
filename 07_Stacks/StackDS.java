import java.util.ArrayList;

public class StackDS {

    protected int top = -1;
    protected int size;
    protected ArrayList<Integer> stack;

    StackDS() {
        this.size = 10;
        this.stack = new ArrayList<>();
    }

    StackDS(int size) {
        this.size = size;
        this.stack = new ArrayList<>();
    }

    public void push(int data) {
        // Check If stack is full
        if (top == size - 1) {
            System.err.println("Stack Overflow!");
            return;
        }

        // if not, add element at top of the stack
        top++;
        stack.add(data);
    }

    public void pop() {
        // Check if stack is empty
        if (top == -1) {
            System.err.println("Stack UnderFlow!");
            return;
        }

        stack.remove(top);
        top--;
    }

    public boolean isFull(){
        if (top == size-1) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if (top == -1) {
            return true;
        }else{
            return false;
        }
    }

    public int getTop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty!");
        }
        return stack.get(top);
    }

    public int getSize(){
        if (top == -1) {
            throw new IllegalStateException("Stack is empty!");
        }
        return top+1; 
    }

    public void print() {
        if (top == -1) {
            System.err.println("Stack is Empty!");
            return;
        }

        for (int i=top ; i >= 0 ; i--) {
            System.out.println(stack.get(i));
        }
    }

    @Override
    public String toString() {
        if (top == -1) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(stack.get(i));
            if (i != 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackDS stack = new StackDS(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.print();

        System.out.println(stack);
        
    }
}
