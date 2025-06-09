import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingChar {

    public static void firstNonRepeatingChar(String stream) {
        Queue<Character> q = new ArrayDeque<>();
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);

            // 1. Update frequency of the character
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // 2. Add character to queue
            q.offer(ch);

            // 3. Remove characters from front of queue if they are repeating
            while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                q.poll();
            }

        }

        if (!q.isEmpty()) {
            System.out.println("First non-repeating is: " + q.peek());
        } else {
            System.out.println("All are repeated");
        }
    }
        public static void main(String[] args) {
        String stream = "ababc";

        firstNonRepeatingChar(stream);
    }
}
