/*
    Approach:
    1. First, check if there is a cycle using the fast & slow pointer method.
    2. If a cycle is found, reset the slow pointer to the head.
    3. Move both fast and slow pointers one step at a time.
    4. The node where they meet again is the starting point of the cycle.
*/

public class DetectCycle {

    protected static Node head = null;

    protected static class Node {
        protected int data;
        protected Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Returns the meeting point of slow and fast if cycle exists, otherwise null
    public static Node checkCycle(Node head) {
        Node fast = head;
        Node slow = head;

        // Move slow by 1 and fast by 2 steps
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // If both pointers meet, a cycle is detected
            if (slow == fast) {
                return fast;  // return meeting point
            }
        }

        // No cycle found
        return null;
    }

    // Detects the starting node of the cycle if it exists
    public static Node detectCycle(Node head) {

        // Step 1: Detect if there is a cycle
        Node fast = checkCycle(head);
        if (fast == null) {
            return null;  // No cycle
        }

        // Step 2: Reset slow pointer to head
        Node slow = head;

        // Step 3: Move both pointers one step at a time until they meet
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        // Return starting point of the cycle
        return slow;
    }

    // Removes the cycle by setting the last node's next to null
    public static void removeCycle(Node head) {

        Node startOfCycle = detectCycle(head);
        if (startOfCycle == null) return; // No cycle exists

        Node temp = startOfCycle;
        // Traverse the cycle to find the last node in the cycle
        while (temp.next != startOfCycle) {
            temp = temp.next;
        }
        temp.next = null; // Break the cycle
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);

        n1.next = n2;
        n2.next = n1; // Cycle starts here
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n1;

        head = n1;

        Node result = detectCycle(head);
        if (result != null) {
            System.out.println("Starting point of cycle is : " + result.data);
        } else {
            System.out.println("No cycle detected.");
        }

        removeCycle(head);

        if (checkCycle(head) == null) {
            System.out.println("Cycle Removed");
        }else{
            System.out.println("Cycle still exists");
        }
    }
}
