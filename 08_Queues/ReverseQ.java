import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQ {

    public static void reverseQ(Deque<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        // Move all elements from queue to stack
        while (!q.isEmpty()) {
            stack.push(q.removeFirst());
        }
        
        // Move all elements back from stack to queue
        while (!stack.isEmpty()) {
            q.addLast(stack.pop());
        }
    }


    //Without using stack
    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int front = q.poll();   //Return front and remove
        reverse(q);
        q.add(front);
    }

    public static void main(String[] args) {
        Deque<Integer> Q = new ArrayDeque<>();

        Q.add(10);
        Q.add(20);
        Q.add(30);
        Q.add(40);

        System.out.println("Original Queue: " + Q);

        reverseQ(Q);

        System.out.println("Reversed Queue: " + Q);
    }
}
