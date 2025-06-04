import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElement {

    public static void reverseK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) {
            return;  // Edge case
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Add them back to the queue (reversed order)
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move the remaining (n - k) elements to the back to preserve order
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println("Original Queue: " + q);

        reverseK(q, 4);

        System.out.println("Queue after reversing: " + q);
    }
}
