/*
 * Input: 1 -> 9 -> 9     Output: 2 -> 0 -> 0 
 * Input: 9 -> 9 -> 9     Output: 1 -> 0 -> 0 -> 0
 *
 * Approach:
 * 1. Reverse the list
 * 2. Add 1 and propagate the carry
 * 3. If carry still exists after traversal, create a new node
 * 4. Reverse the list back to original order
 */

public class Add1 extends CreationOfSinglyList {

    public static Node reversNode(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;   // For tracking next node
            curr.next = prev;        // Reversing the link
            prev = curr;
            curr = next;
        }

        return prev; // Returning new head (reversed head)
    }

    public static Node add1(Node head, int num) {

        // 1. Reverse the list
        head = reversNode(head);

        Node temp = head;
        int carry = num; // Start by adding 1
        Node prev = null;

        // 2. Traverse and add carry
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) break; // If there's no carry, stop

            prev = temp;
            temp = temp.next;
        }

        // 3. If carry still exists, add new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        // 4. Reverse back
        head = reversNode(head);
        return head;
    }

    public static void main(String[] args) {
        add(9);
        add(9);
        add(9);

        printList(head);
        head = add1(head, 1);
        printList(head);
    }
}
