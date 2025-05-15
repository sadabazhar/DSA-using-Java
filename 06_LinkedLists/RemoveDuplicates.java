public class RemoveDuplicates extends CreationOfSinglyList{

    public static void removeDuplicates(Node head) {

        if (head == null || head.next == null) return;

        Node pre = head;
        Node curr = pre.next;

        while (curr != null) {
            if (pre.data == curr.data) {
                
                // Move curr to next node, for skipping duplicate
                Node currTemp = curr;
                curr = curr.next;

                // Nullify duplicate node
                currTemp.next = null;
            } else {
                // Connect pre node to the next unique node
                pre.next = curr;

                // Move both pointers forward
                pre = pre.next;
                curr = curr.next;
            }
        }

        // Pre node stand at tail, set null
        pre.next = null;
    }


    public static void main(String[] args) {
        add(10);
        add(10);
        add(10);
        add(10);
        add(20);

        printList(head);
        removeDuplicates(head);
        printList(head);
    }
}
