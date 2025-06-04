import java.util.ArrayDeque;
import java.util.Queue;

public class InterleaveHalfs {

    public static void interleaveQ(Queue<Integer> q) {
        int size = q.size();

        // Works only for even size
        if (size % 2 != 0) {
            System.out.println("Queue must be even");
            return;
        }

        Queue<Integer> firstHalf = new ArrayDeque<>();

        // Step 1: Move first half to another queue
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.poll());
        }

        // Step 2: Interleave both halves
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.poll());  // from first half
            q.add(q.poll());          // from second half (already in q)
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);

        System.out.println("Original Queue: " + q);

        interleaveQ(q);

        System.out.println("Interleaved Queue: " + q);
    }
}
